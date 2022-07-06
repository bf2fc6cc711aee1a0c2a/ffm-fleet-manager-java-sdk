package com.redhat.services.ffm.ams.utils.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.redhat.services.ffm.ams.utils.auth.exceptions.OidcTokensNotInitializedException;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.OidcClientConfig;
import io.quarkus.oidc.client.OidcClientException;
import io.quarkus.oidc.client.OidcClients;
import io.quarkus.oidc.client.Tokens;
import io.smallrye.mutiny.Uni;

public class AbstractTokenProviderTest {

    private static final String NAME = "test-sso";
    private static final String ACCESS_TOKEN = "access";
    private static final String REFRESH_TOKEN = "refresh";

    private OidcClient oidcClient;
    private Tokens tokens;
    private TestOidcClient client;

    private static class TestOidcClient extends AbstractTokenProvider {

        public TestOidcClient(String name, OidcClients oidcClients) {
            super(name, oidcClients);
        }

        @Override
        public void init() {
            super.init();
        }

        @Override
        public void checkAndRefresh() {
            super.checkAndRefresh();
        }

        @Override
        public String getToken() {
            return super.getToken();
        }

        @Override
        protected OidcClientConfig getOidcClientConfig() {
            return new OidcClientConfig();
        }

        @Override
        protected void scheduledLoop() {
        }
    }

    @BeforeEach
    void init() {

        OidcClients oidcClients = Mockito.mock(OidcClients.class);
        oidcClient = Mockito.mock(OidcClient.class);
        tokens = Mockito.mock(Tokens.class);
        Mockito.when(tokens.getAccessToken()).thenReturn(ACCESS_TOKEN);
        Mockito.when(tokens.getRefreshToken()).thenReturn(REFRESH_TOKEN);
        Mockito.when(oidcClient.getTokens()).thenReturn(Uni.createFrom().item(tokens));
        Mockito.when(oidcClient.refreshTokens(ArgumentMatchers.any(String.class))).thenReturn(Uni.createFrom().item(tokens));
        Mockito.when(oidcClients.newClient(ArgumentMatchers.any(OidcClientConfig.class)))
                .thenReturn(Uni.createFrom().item(oidcClient));

        client = new TestOidcClient(NAME, oidcClients);
    }

    @Test
    public void tokensNotInitialized() {
        Assertions.assertThatExceptionOfType(OidcTokensNotInitializedException.class).isThrownBy(() -> client.getToken());
    }

    @Test
    public void tokensAreInizialized() {
        client.init();
        Assertions.assertThat(client.getToken()).isEqualTo(ACCESS_TOKEN);
    }

    @Test
    public void expiredTokenAreRefreshed() {
        // Given
        client.init();
        Mockito.when(tokens.isAccessTokenExpired()).thenReturn(true);

        // When
        client.checkAndRefresh();

        // Then
        Mockito.verify(oidcClient, Mockito.times(1)).refreshTokens(ArgumentMatchers.any(String.class));
    }

    @Test
    public void tokenIsInRefreshInterval() {
        // Given
        client.init();
        Mockito.when(tokens.isAccessTokenWithinRefreshInterval()).thenReturn(true);

        // When
        client.checkAndRefresh();

        // Then
        Mockito.verify(oidcClient, Mockito.times(1)).refreshTokens(ArgumentMatchers.any(String.class));
    }

    @Test
    public void expiredRefreshTokenAreRenewed() {
        // Given
        client.init();
        Mockito.when(tokens.isAccessTokenExpired()).thenReturn(true);
        Mockito.when(oidcClient.refreshTokens(ArgumentMatchers.any(String.class))).thenThrow(new OidcClientException());

        // When
        client.checkAndRefresh();

        // Then
        Mockito.verify(oidcClient, Mockito.times(2)).getTokens();
    }
}
