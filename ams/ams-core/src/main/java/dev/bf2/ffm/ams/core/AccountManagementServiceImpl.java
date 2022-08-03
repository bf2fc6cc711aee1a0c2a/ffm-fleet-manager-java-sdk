package dev.bf2.ffm.ams.core;

import java.util.Collections;

import dev.bf2.ffm.ams.client.api.DefaultApi;
import dev.bf2.ffm.ams.client.models.ClusterAuthorizationRequest;
import dev.bf2.ffm.ams.client.models.QuotaCost;
import dev.bf2.ffm.ams.client.models.RelatedResource;
import dev.bf2.ffm.ams.client.models.ReservedResource;
import dev.bf2.ffm.ams.client.models.TermsReview;
import dev.bf2.ffm.ams.client.models.TermsReviewResponse;
import dev.bf2.ffm.ams.core.exceptions.CreationNotAllowedException;
import dev.bf2.ffm.ams.core.exceptions.TermsRequiredException;
import dev.bf2.ffm.ams.core.models.AccountInfo;
import dev.bf2.ffm.ams.core.models.CreateResourceRequest;
import dev.bf2.ffm.ams.core.models.ResourceCreated;
import io.smallrye.mutiny.Uni;

class AccountManagementServiceImpl implements AccountManagementService {

    private DefaultApi defaultApi;

    AccountManagementServiceImpl(DefaultApi defaultApi) {
        this.defaultApi = defaultApi;
    }

    @Override
    public Uni<ResourceCreated> createResource(CreateResourceRequest createResourceRequest) {
        return assertAcceptedTerms(createResourceRequest)
                .onItem()
                .transformToUni(x -> Uni.createFrom()
                        .completionStage(defaultApi.apiAccountsMgmtV1ClusterAuthorizationsPost(
                                buildClusterAuthorizationRequest(createResourceRequest))))
                .onItem()
                .transformToUni(x -> {
                    if (!x.getAllowed()) {
                        return Uni.createFrom()
                                .failure(new CreationNotAllowedException("Not allowed to create to create the resource."));
                    }
                    ResourceCreated resourceCreated = new ResourceCreated.Builder()
                            .withSubscriptionId(x.getSubscription().getId()).build();
                    return Uni.createFrom().item(resourceCreated);
                });
    }

    @Override
    public Uni<Void> deleteResource(String subscriptionId) {
        return Uni.createFrom().completionStage(defaultApi.apiAccountsMgmtV1SubscriptionsIdDelete(subscriptionId));
    }

    @Override
    public Uni<Boolean> organizationHasAvailableQuota(AccountInfo accountInfo, String product, String resourceName) {
        return Uni.createFrom()
                .completionStage(defaultApi.apiAccountsMgmtV1OrganizationsIdGet(accountInfo.getOrganizationId(), false, false))
                .onItem()
                .transformToUni(
                        x -> Uni.createFrom().completionStage(defaultApi.apiAccountsMgmtV1QuotaCostGet(x.getId(), true, false)))
                .onItem()
                .transformToUni(x -> Uni.createFrom().item(
                        x.getItems()
                                .stream()
                                .anyMatch(y -> checkProductAndAllowedQuota(y, product, resourceName))));
    }

    private boolean checkProductAndAllowedQuota(QuotaCost quotaCost, String product, String resourceName) {
        if (quotaCost.getAllowed() > 0 && quotaCost.getRelatedResources() != null
                && !quotaCost.getRelatedResources().isEmpty()) {
            for (RelatedResource relatedResource : quotaCost.getRelatedResources()) {
                if (product.equals(relatedResource.getProduct()) && resourceName.equals(relatedResource.getResourceName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private ClusterAuthorizationRequest buildClusterAuthorizationRequest(CreateResourceRequest createResourceRequest) {
        ReservedResource reservedResource = new ReservedResource();
        reservedResource.setResourceName(createResourceRequest.getResourceName());
        reservedResource.setBillingModel(createResourceRequest.getBillingModel());
        reservedResource.setAvailabilityZoneType(createResourceRequest.getAvailabilityZoneType());
        reservedResource.setCount(createResourceRequest.getCount());

        // Setting default values
        reservedResource.setByoc(false);

        ClusterAuthorizationRequest clusterAuthorizationRequest = new ClusterAuthorizationRequest();
        clusterAuthorizationRequest.setAccountUsername(createResourceRequest.getAccountInfo().getAccountUsername());
        clusterAuthorizationRequest
                .setProductId(ClusterAuthorizationRequest.ProductIdEnum.fromValue(createResourceRequest.getProductId()));
        clusterAuthorizationRequest.setCloudProviderId(createResourceRequest.getCloudProviderId());
        clusterAuthorizationRequest.setAvailabilityZone(createResourceRequest.getAvailabilityZoneType());
        clusterAuthorizationRequest.setClusterId(createResourceRequest.getClusterId());
        clusterAuthorizationRequest.setResources(Collections.singletonList(reservedResource));

        // Setting default values
        clusterAuthorizationRequest.setReserve(true);
        clusterAuthorizationRequest.setManaged(true);
        clusterAuthorizationRequest.setByoc(false);

        return clusterAuthorizationRequest;
    }

    private Uni<TermsReviewResponse> assertAcceptedTerms(CreateResourceRequest createResourceRequest) {
        // Check if the user has accepted the Terms & Conditions

        final TermsReview termsReview = new TermsReview();
        termsReview.setAccountUsername(createResourceRequest.getAccountInfo().getAccountUsername());
        termsReview.setSiteCode(createResourceRequest.getTermRequest().getSiteCode());
        termsReview.setEventCode(createResourceRequest.getTermRequest().getEventCode());

        return Uni
                .createFrom()
                .completionStage(defaultApi.apiAuthorizationsV1TermsReviewPost(termsReview))
                .onItem()
                .transformToUni(x -> {
                    if (Boolean.TRUE.equals(x.getTermsAvailable()) && Boolean.TRUE.equals(x.getTermsRequired())) {
                        return Uni.createFrom()
                                .failure(new TermsRequiredException("The terms conditions haven't been accepted yet."));
                    }
                    return Uni.createFrom().item(x);
                });
    }
}
