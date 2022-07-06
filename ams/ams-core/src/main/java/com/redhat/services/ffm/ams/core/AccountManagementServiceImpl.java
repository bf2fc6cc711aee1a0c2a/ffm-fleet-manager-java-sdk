package com.redhat.services.ffm.ams.core;

import java.util.Collections;

import com.redhat.services.ffm.ams.client.api.DefaultApi;
import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;
import com.redhat.services.ffm.ams.client.models.ReservedResource;
import com.redhat.services.ffm.ams.client.models.TermsReview;
import com.redhat.services.ffm.ams.client.models.TermsReviewResponse;
import com.redhat.services.ffm.ams.core.exceptions.CreationNotAllowedException;
import com.redhat.services.ffm.ams.core.exceptions.TermsRequiredException;
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
                    ResourceCreated resourceCreated = new ResourceCreated.Builder().withId(x.getSubscription().getId()).build();
                    return Uni.createFrom().item(resourceCreated);
                });
    }

    private ClusterAuthorizationRequest buildClusterAuthorizationRequest(CreateResourceRequest createResourceRequest) {
        ReservedResource reservedResource = new ReservedResource();
        reservedResource.setByoc(false);
        reservedResource.setResourceName(createResourceRequest.getResourceName());
        reservedResource.setBillingModel(createResourceRequest.getBillingModel());
        reservedResource.setAvailabilityZoneType(createResourceRequest.getAvailabilityZoneType());
        reservedResource.setCount(createResourceRequest.getCount());

        ClusterAuthorizationRequest clusterAuthorizationRequest = new ClusterAuthorizationRequest();
        clusterAuthorizationRequest.setAccountUsername(createResourceRequest.getAccountInfo().getAccountUsername());
        clusterAuthorizationRequest
                .setProductId(ClusterAuthorizationRequest.ProductIdEnum.fromValue(createResourceRequest.getProductId()));
        clusterAuthorizationRequest.setManaged(true);
        clusterAuthorizationRequest.setByoc(false);
        clusterAuthorizationRequest.setCloudProviderId(createResourceRequest.getCloudProviderId());
        clusterAuthorizationRequest.setReserve(true);
        clusterAuthorizationRequest.setAvailabilityZone(createResourceRequest.getAvailabilityZoneType());
        clusterAuthorizationRequest.setClusterId(createResourceRequest.getClusterId());
        clusterAuthorizationRequest.setResources(Collections.singletonList(reservedResource));

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
