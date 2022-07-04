package com.redhat.services.ffm.ams.core;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.verification.LoggedRequest;
import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;
import com.redhat.services.ffm.ams.core.exceptions.CreationNotAllowedException;
import com.redhat.services.ffm.ams.core.exceptions.TermsRequiredException;
import com.redhat.services.ffm.ams.core.models.AccountInfo;
import com.redhat.services.ffm.ams.core.models.AccountManagementServiceClientConfig;
import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;
import com.redhat.services.ffm.ams.core.models.ResourceCreated;
import com.redhat.services.ffm.ams.core.models.TermRequest;
import com.redhat.services.ffm.ams.infra.auth.TokenProvider;

import io.smallrye.mutiny.Uni;

public class AccountManagementServiceImplTest {

    WireMockServer wireMockServer;

    @BeforeEach
    void init() {
        wireMockServer = new WireMockServer(wireMockConfig().dynamicPort()); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
    }

    @AfterEach
    void cleanup() {
        wireMockServer.stop();
    }

    @Test
    void tokenIsAddedToRequests() {
        AMSWiremockUtils.stubTermsReturn500(wireMockServer);
        TokenProvider tokenProvider = new TokenProvider() {
            @Override
            public String getName() {
                return "mocked";
            }

            @Override
            public String getToken() {
                return "token";
            }
        };
        AccountManagementService accountManagementService = buildAccountManagementService(tokenProvider);
        CreateResourceRequest createResourceRequest = craftCreateResourceRequest();

        Uni<ResourceCreated> response = accountManagementService.createResource(createResourceRequest);
        try {
            response.await().atMost(Duration.ofSeconds(10));
        } catch (Exception ignored) {
        }

        List<LoggedRequest> findAll = wireMockServer
                .findAll(postRequestedFor(
                        urlEqualTo(Constants.TERMS_PATH))
                                .withHeader("Authorization", equalTo("Bearer token")));

        Assertions.assertThat(findAll).hasSize(1);
    }

    @Test
    void tokenIsNotAddedToRequests() {
        AMSWiremockUtils.stubTermsReturn500(wireMockServer);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        CreateResourceRequest createResourceRequest = craftCreateResourceRequest();

        Uni<ResourceCreated> response = accountManagementService.createResource(createResourceRequest);
        try {
            response.await().atMost(Duration.ofSeconds(10));
        } catch (Exception ignored) {
        }

        List<LoggedRequest> findAll = wireMockServer
                .findAll(postRequestedFor(
                        urlEqualTo(Constants.TERMS_PATH))
                                .withoutHeader("Authorization"));

        Assertions.assertThat(findAll).hasSize(1);
    }

    @Test
    void throwIfTermsWereNotAccepted() {
        AMSWiremockUtils.stubTermsNotAccepted(wireMockServer);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        CreateResourceRequest createResourceRequest = craftCreateResourceRequest();

        Uni<ResourceCreated> response = accountManagementService.createResource(createResourceRequest);
        Assertions.assertThatThrownBy(() -> response.await().atMost(Duration.ofSeconds(10)))
                .isInstanceOf(TermsRequiredException.class);
    }

    @Test
    void throwIfCreationNotAllowed() {
        AMSWiremockUtils.stubTermsAccepted(wireMockServer);
        AMSWiremockUtils.stubCreationFailed(wireMockServer);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        CreateResourceRequest createResourceRequest = craftCreateResourceRequest();

        Uni<ResourceCreated> response = accountManagementService.createResource(createResourceRequest);
        Assertions.assertThatThrownBy(() -> response.await().atMost(Duration.ofSeconds(10)))
                .isInstanceOf(CreationNotAllowedException.class);
    }

    @Test
    void creationAllowed() {
        AMSWiremockUtils.stubTermsAccepted(wireMockServer);
        AMSWiremockUtils.stubCreationSuccessfull(wireMockServer);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        CreateResourceRequest createResourceRequest = craftCreateResourceRequest();

        Uni<ResourceCreated> response = accountManagementService.createResource(createResourceRequest);
        Assertions.assertThat(response.await().atMost(Duration.ofSeconds(10)).getId())
                .isEqualTo(Constants.DEFAULT_SUBSCRIPTION_ID);
    }

    private AccountManagementService buildAccountManagementService(TokenProvider tokenProvider) {
        AccountManagementServiceClientConfig config = new AccountManagementServiceClientConfig();
        config.setPort(wireMockServer.port());

        return new AccountManagementServiceBuilder()
                .withConfig(config)
                .withTokenProvider(tokenProvider)
                .build();
    }

    private CreateResourceRequest craftCreateResourceRequest() {
        CreateResourceRequest createResourceRequest = new CreateResourceRequest();

        createResourceRequest.setAccountInfo(new AccountInfo(Constants.DEFAULT_ORGANIZATION_ID, Constants.DEFAULT_USERNAME,
                false, Constants.DEFAULT_ACCOUNT_ID));
        createResourceRequest
                .setTermRequest(new TermRequest(Constants.DEFAULT_TERM_SITE_CODE, Constants.DEFAULT_TERM_EVENT_CODE));
        createResourceRequest.setResourceName(Constants.DEFAULT_RESOURCE_NAME);
        createResourceRequest.setCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID);
        createResourceRequest.setClusterId(Constants.DEFAULT_CLUSTER_ID);
        createResourceRequest.setBillingModel(Constants.DEFAULT_BILLING_MODEL);
        createResourceRequest.setAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE);
        createResourceRequest.setCount(Constants.DEFAULT_COUNT);
        createResourceRequest.setProductId(ClusterAuthorizationRequest.ProductIdEnum.OSD.getValue());

        return createResourceRequest;
    }
}
