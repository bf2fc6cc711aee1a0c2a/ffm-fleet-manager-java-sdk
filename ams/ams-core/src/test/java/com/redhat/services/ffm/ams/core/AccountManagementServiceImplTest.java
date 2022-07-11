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
import com.redhat.services.ffm.ams.client.ApiException;
import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;
import com.redhat.services.ffm.ams.core.exceptions.CreationNotAllowedException;
import com.redhat.services.ffm.ams.core.exceptions.TermsRequiredException;
import com.redhat.services.ffm.ams.core.models.AccountInfo;
import com.redhat.services.ffm.ams.core.models.AccountManagementServiceClientConfig;
import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;
import com.redhat.services.ffm.ams.core.models.ResourceCreated;
import com.redhat.services.ffm.ams.core.models.TermsRequest;
import com.redhat.services.ffm.ams.utils.auth.TokenProvider;

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
        Assertions.assertThat(response.await().atMost(Duration.ofSeconds(10)).getSubscriptionId())
                .isEqualTo(Constants.DEFAULT_SUBSCRIPTION_ID);
    }

    @Test
    void deleteResourceRaiseException() {
        AMSWiremockUtils.stubDeletionFailed(wireMockServer, Constants.DEFAULT_SUBSCRIPTION_ID);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        Uni<Void> response = accountManagementService.deleteResource(Constants.DEFAULT_SUBSCRIPTION_ID);

        Assertions.assertThatThrownBy(() -> response.await().atMost(Duration.ofSeconds(5)))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void deleteResourceReturnsVoidIfSuccessful() {
        AMSWiremockUtils.stubDeletionSuccessfull(wireMockServer, Constants.DEFAULT_SUBSCRIPTION_ID);
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        Uni<Void> response = accountManagementService.deleteResource(Constants.DEFAULT_SUBSCRIPTION_ID);

        Assertions.assertThat(response.await().atMost(Duration.ofSeconds(5))).isNull();
    }

    @Test
    void organizationHasAvailableQuotaNotImplementedYet() {
        AccountManagementService accountManagementService = buildAccountManagementService(null);
        Uni<Boolean> response = accountManagementService.organizationHasAvailableQuota(Constants.DEFAULT_ACCOUNT_INFO,
                Constants.DEFAULT_PRODUCT_ID.getValue(), Constants.DEFAULT_RESOURCE_NAME);

        Assertions.assertThatThrownBy(() -> response.await().atMost(Duration.ofSeconds(5))).hasMessage("Not implemented yet.");
    }

    private AccountManagementService buildAccountManagementService(TokenProvider tokenProvider) {
        AccountManagementServiceClientConfig config = new AccountManagementServiceClientConfig.Builder()
                .withPort(wireMockServer.port())
                .build();

        return new AccountManagementServiceBuilder()
                .withConfig(config)
                .withTokenProvider(tokenProvider)
                .build();
    }

    private CreateResourceRequest craftCreateResourceRequest() {
        CreateResourceRequest createResourceRequest = new CreateResourceRequest.Builder()
                .withAccountInfo(new AccountInfo.Builder()
                        .withOrganizationId(Constants.DEFAULT_ORGANIZATION_ID)
                        .withAccountUsername(Constants.DEFAULT_USERNAME)
                        .withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                        .withAdminRole(false)
                        .build())
                .withTermRequest(new TermsRequest.Builder()
                        .withSiteCode(Constants.DEFAULT_TERM_SITE_CODE)
                        .withEventCode(Constants.DEFAULT_TERM_EVENT_CODE)
                        .build())
                .withResourceName(Constants.DEFAULT_RESOURCE_NAME)
                .withCloudProviderId((Constants.DEFAULT_CLOUD_PROVIDER_ID))
                .withClusterId(Constants.DEFAULT_CLUSTER_ID)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withCount(Constants.DEFAULT_COUNT)
                .withProductId(ClusterAuthorizationRequest.ProductIdEnum.OSD.getValue())
                .build();

        return createResourceRequest;
    }
}
