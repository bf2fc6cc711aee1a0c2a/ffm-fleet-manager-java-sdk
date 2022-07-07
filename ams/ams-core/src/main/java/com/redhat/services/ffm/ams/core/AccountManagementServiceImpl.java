package com.redhat.services.ffm.ams.core;

import java.util.Collections;

import com.redhat.services.ffm.ams.client.api.DefaultApi;
import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;
import com.redhat.services.ffm.ams.client.models.ReservedResource;
import com.redhat.services.ffm.ams.client.models.TermsReview;
import com.redhat.services.ffm.ams.client.models.TermsReviewResponse;
import com.redhat.services.ffm.ams.core.exceptions.CreationNotAllowedException;
import com.redhat.services.ffm.ams.core.exceptions.TermsRequiredException;
import com.redhat.services.ffm.ams.core.models.AccountInfo;
import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;
import com.redhat.services.ffm.ams.core.models.ResourceCreated;

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
    public Uni<Void> deleteResource(String resourceId) {
        return Uni.createFrom().failure(new RuntimeException("Not implemented yet."));
    }

    @Override
    public Uni<Boolean> organizationHasAvailableQuota(AccountInfo accountInfo, String productId, String resourceName) {
        return Uni.createFrom().failure(new RuntimeException("Not implemented yet."));
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
