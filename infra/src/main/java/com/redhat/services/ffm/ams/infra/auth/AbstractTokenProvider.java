package com.redhat.services.ffm.ams.infra.auth;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.services.ffm.ams.infra.auth.exceptions.OidcTokensNotInitializedException;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.OidcClientConfig;
import io.quarkus.oidc.client.OidcClientException;
import io.quarkus.oidc.client.OidcClients;
import io.quarkus.oidc.client.Tokens;

/**
 *
 * Using the following dependency
 *
 * &lt;dependency&gt;
 * &lt;groupId&gt;io.quarkus&lt;/groupId&gt;
 * &lt;artifactId&gt;quarkus-scheduler&lt;/artifactId&gt;
 * &lt;/dependency&gt;
 *
 * a sample implementation is the following
 *
 * <pre>
 * &#64;ApplicationScoped
 * public class WebhookOidcClient extends AbstractOidcClient {
 *
 *     private static final String NAME = OidcClientConstants.WEBHOOK_OIDC_CLIENT_NAME;
 *
 *     &#64;ConfigProperty(name = "sso.auth-server-url")
 *     String serverUrl;
 *
 *     &#64;ConfigProperty(name = "sso.webhook-client-id")
 *     String clientId;
 *
 *     &#64;ConfigProperty(name = "sso.credentials.webhook-client-secret")
 *     String secret;
 *
 *     &#64;Inject
 *     public WebhookOidcClient(OidcClients oidcClients) {
 *         super(NAME, oidcClients);
 *     }
 *
 *     &#64;Override
 *     protected OidcClientConfig getOidcClientConfig() {
 *         OidcClientConfig oidcClientConfig = new OidcClientConfig();
 *         oidcClientConfig.setId(NAME);
 *         oidcClientConfig.setAuthServerUrl(serverUrl);
 *         oidcClientConfig.setClientId(clientId);
 *         oidcClientConfig.getCredentials().setSecret(secret);
 *         oidcClientConfig.setRefreshTokenTimeSkew(AbstractOidcClient.REFRESH_TOKEN_TIME_SKEW);
 *
 *         return oidcClientConfig;
 *     }
 *
 *     &#64;Override
 *     &#64;Scheduled(every = AbstractOidcClient.SCHEDULER_TIME)
 *     protected void scheduledLoop() {
 *         super.checkAndRefresh();
 *     }
 * }
 * </pre>
 */
public abstract class AbstractTokenProvider implements TokenProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTokenProvider.class);

    protected static final String SCHEDULER_TIME = "5s";
    protected static final Duration SSO_CONNECTION_TIMEOUT = Duration.ofSeconds(30);
    protected static final Duration REFRESH_TOKEN_TIME_SKEW = Duration.ofSeconds(30);

    protected String name;
    protected OidcClient client;
    private OidcClients oidcClients;
    protected Duration timeout;
    protected Tokens currentTokens;

    public AbstractTokenProvider() {
    }

    public AbstractTokenProvider(String name, OidcClients oidcClients, Duration timeout) {
        this.name = name;
        this.oidcClients = oidcClients;
        this.timeout = timeout;
    }

    public AbstractTokenProvider(String name, OidcClients oidcClients) {
        this(name, oidcClients, SSO_CONNECTION_TIMEOUT);
    }

    protected abstract OidcClientConfig getOidcClientConfig();

    protected abstract void scheduledLoop();

    @PostConstruct
    protected void init() {
        this.client = oidcClients.newClient(getOidcClientConfig()).await().atMost(timeout);
        retrieveTokens();
    }

    /**
     * It is not possible to annotate this method with `@Scheduled` so it has to be done by the child classes.
     * TODO: check if with a quarkus extension this can be achieved
     */
    protected void checkAndRefresh() {
        if (currentTokens.isAccessTokenExpired() || currentTokens.isAccessTokenWithinRefreshInterval()) {
            refreshTokens();
            LOGGER.debug("Tokens have been refreshed for OIDC client '{}'", name);
        }
    }

    /**
     * Gets the token.
     *
     * @return the token.
     */
    public String getToken() {
        if (currentTokens == null) {
            throw new OidcTokensNotInitializedException(
                    String.format("Tokens for OIDC client '%s' are not initialized.", name));
        }
        return currentTokens.getAccessToken();
    }

    public String getName() {
        return this.name;
    }

    private void refreshTokens() {
        Tokens tokens = currentTokens;
        try {
            currentTokens = client.refreshTokens(tokens.getRefreshToken()).await().atMost(timeout);
        } catch (OidcClientException e) {
            LOGGER.debug("Could not use refresh token. Trying to get a new fresh token for OIDC client '{}'", name);
            retrieveTokens();
        }
    }

    protected void retrieveTokens() {
        currentTokens = client.getTokens().await().atMost(timeout);
        LOGGER.debug("New token for OIDC client '{}' has been set", name);
    }
}
