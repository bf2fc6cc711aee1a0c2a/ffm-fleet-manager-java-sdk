package dev.bf2.ffm.ams.core.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.bf2.ffm.ams.core.Constants;

public class CreateResourceRequestTest {

    @Test
    void builderThrowsExceptionIfMandatoryPropertyIsMissing() {
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder().build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID)
                .withClusterId(Constants.DEFAULT_CLUSTER_ID)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID)
                .withClusterId(Constants.DEFAULT_CLUSTER_ID)
                .withProductId(Constants.DEFAULT_PRODUCT_ID.getValue())
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID)
                .withClusterId(Constants.DEFAULT_CLUSTER_ID)
                .withResourceName(Constants.DEFAULT_RESOURCE_NAME)
                .build())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void builderSetsAllProperties() {
        CreateResourceRequest createResourceRequest = new CreateResourceRequest.Builder()
                .withAccountInfo(Constants.DEFAULT_ACCOUNT_INFO)
                .withTermRequest(Constants.DEFAULT_TERMS_REQUEST)
                .withCount(Constants.DEFAULT_COUNT)
                .withAvailabilityZoneType(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE)
                .withBillingModel(Constants.DEFAULT_BILLING_MODEL)
                .withCloudProviderId(Constants.DEFAULT_CLOUD_PROVIDER_ID)
                .withClusterId(Constants.DEFAULT_CLUSTER_ID)
                .withResourceName(Constants.DEFAULT_RESOURCE_NAME)
                .withProductId(Constants.DEFAULT_PRODUCT_ID.getValue())
                .build();
        Assertions.assertThat(createResourceRequest.getResourceName()).isEqualTo(Constants.DEFAULT_RESOURCE_NAME);
        Assertions.assertThat(createResourceRequest.getAvailabilityZoneType())
                .isEqualTo(Constants.DEFAULT_AVAILABILITY_ZONE_TYPE);
        Assertions.assertThat(createResourceRequest.getBillingModel()).isEqualTo(Constants.DEFAULT_BILLING_MODEL);
        Assertions.assertThat(createResourceRequest.getCount()).isEqualTo(Constants.DEFAULT_COUNT);
        Assertions.assertThat(createResourceRequest.getTermRequest()).isEqualTo(Constants.DEFAULT_TERMS_REQUEST);
        Assertions.assertThat(createResourceRequest.getCloudProviderId()).isEqualTo(Constants.DEFAULT_CLOUD_PROVIDER_ID);
        Assertions.assertThat(createResourceRequest.getClusterId()).isEqualTo(Constants.DEFAULT_CLUSTER_ID);
        Assertions.assertThat(createResourceRequest.getProductId()).isEqualTo(Constants.DEFAULT_PRODUCT_ID.getValue());
        Assertions.assertThat(createResourceRequest.getAccountInfo()).isEqualTo(Constants.DEFAULT_ACCOUNT_INFO);
    }
}
