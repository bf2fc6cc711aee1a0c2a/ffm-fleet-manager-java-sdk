package com.redhat.services.ffm.ams.core.models;

import java.util.Objects;

/**
 * This class contains all the information for the creation of a resource on Account Management Service.
 */
public class CreateResourceRequest {

    private final AccountInfo accountInfo;
    private final TermRequest termRequest;
    private final String productId;
    private final String cloudProviderId;
    private final String clusterId;
    private final String resourceName;
    private final String billingModel;
    private final String availabilityZoneType;
    private final Integer count;

    protected CreateResourceRequest(AccountInfo accountInfo, TermRequest termRequest, String productId, String cloudProviderId,
            String clusterId, String resourceName, String billingModel, String availabilityZoneType, Integer count) {
        this.accountInfo = accountInfo;
        this.termRequest = termRequest;
        this.productId = productId;
        this.cloudProviderId = cloudProviderId;
        this.clusterId = clusterId;
        this.resourceName = resourceName;
        this.billingModel = billingModel;
        this.availabilityZoneType = availabilityZoneType;
        this.count = count;
    }

    /**
     * Gets the AccountInfo.
     *
     * @return the account info object.
     */
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * Gets the TermRequest.
     *
     * @return the term request object.
     */
    public TermRequest getTermRequest() {
        return termRequest;
    }

    /**
     * Gets the product id.
     *
     * @return the product id.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Gets the cloud provider id.
     *
     * @return the cloud provider id.
     */
    public String getCloudProviderId() {
        return cloudProviderId;
    }

    /**
     * Gets the cluster id.
     *
     * @return the cluster id.
     */
    public String getClusterId() {
        return clusterId;
    }

    /**
     * Gets the resource name.
     *
     * @return the resource name.
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets the billing model.
     *
     * @return the billing model.
     */
    public String getBillingModel() {
        return billingModel;
    }

    /**
     * Gets the availability zone type.
     *
     * @return the availability zone type.
     */
    public String getAvailabilityZoneType() {
        return availabilityZoneType;
    }

    /**
     * Gets the count.
     *
     * @return the count.
     */
    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateResourceRequest that = (CreateResourceRequest) o;
        return Objects.equals(accountInfo, that.accountInfo) && Objects.equals(termRequest, that.termRequest)
                && Objects.equals(productId, that.productId) && Objects.equals(cloudProviderId, that.cloudProviderId)
                && Objects.equals(clusterId, that.clusterId) && Objects.equals(resourceName, that.resourceName)
                && Objects.equals(billingModel, that.billingModel)
                && Objects.equals(availabilityZoneType, that.availabilityZoneType) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, termRequest, productId, cloudProviderId, clusterId, resourceName, billingModel,
                availabilityZoneType, count);
    }

    /**
     * Builder for {@link CreateResourceRequest}.
     */
    public static class Builder {

        private AccountInfo accountInfo;
        private TermRequest termRequest;
        private String productId;
        private String cloudProviderId;
        private String clusterId;
        private String resourceName;
        private String billingModel;
        private String availabilityZoneType;
        private Integer count;

        public Builder() {
        }

        /**
         * Sets the account information in the builder.
         *
         * @param accountInfo
         * @return the builder.
         */
        public Builder withAccountInfo(AccountInfo accountInfo) {
            this.accountInfo = accountInfo;
            return this;
        }

        /**
         * Sets the term information to be checked in the builder.
         *
         * @param termRequest
         * @return the builder.
         */
        public Builder withTermRequest(TermRequest termRequest) {
            this.termRequest = termRequest;
            return this;
        }

        /**
         * Sets the product id in the builder.
         *
         * @param productId
         * @return the builder.
         */
        public Builder withProductId(String productId) {
            this.productId = productId;
            return this;
        }

        /**
         * Sets the cloud provider id in the builder.
         *
         * @param cloudProviderId
         * @return the builder.
         */
        public Builder withCloudProviderId(String cloudProviderId) {
            this.cloudProviderId = cloudProviderId;
            return this;
        }

        /**
         * Sets the cluster id in the builder.
         *
         * @param clusterId
         * @return the builder.
         */
        public Builder withClusterId(String clusterId) {
            this.clusterId = clusterId;
            return this;
        }

        /**
         * Sets the resource name in the builder.
         *
         * @param resourceName
         * @return the builder.
         */
        public Builder withResourceName(String resourceName) {
            this.resourceName = resourceName;
            return this;
        }

        /**
         * Sets the billing model in the builder.
         *
         * @param billingModel
         * @return the builder.
         */
        public Builder withBillingModel(String billingModel) {
            this.billingModel = billingModel;
            return this;
        }

        /**
         * Sets the availability zone type in the builder.
         *
         * @param availabilityZoneType
         * @return the builder.
         */
        public Builder withAvailabilityZoneType(String availabilityZoneType) {
            this.availabilityZoneType = availabilityZoneType;
            return this;
        }

        /**
         * Sets the count in the builder.
         *
         * @param count
         * @return the builder.
         */
        public Builder withCount(Integer count) {
            this.count = count;
            return this;
        }

        /**
         * Builds the CreateResourceRequest.
         *
         * @return the {@link CreateResourceRequest} instance.
         */
        public CreateResourceRequest build() {
            if (accountInfo == null) {
                throw new IllegalStateException("The account info can't be null.");
            }
            if (termRequest == null) {
                throw new IllegalStateException("The term request can't be null.");
            }
            if (productId == null || productId.isBlank()) {
                throw new IllegalStateException("The product id can't be null or blank.");
            }
            if (cloudProviderId == null || cloudProviderId.isBlank()) {
                throw new IllegalStateException("The cloud provider id can't be null or blank.");
            }
            if (clusterId == null || clusterId.isBlank()) {
                throw new IllegalStateException("The cluster id can't be null or blank.");
            }
            if (resourceName == null || resourceName.isBlank()) {
                throw new IllegalStateException("The resource name can't be null or blank.");
            }
            if (billingModel == null || billingModel.isBlank()) {
                throw new IllegalStateException("The billing model can't be null or blank.");
            }
            if (availabilityZoneType == null || availabilityZoneType.isBlank()) {
                throw new IllegalStateException("The availability zone type can't be null or blank.");
            }
            if (count == null) {
                throw new IllegalStateException("The count can't be null.");
            }
            return new CreateResourceRequest(accountInfo, termRequest, productId, cloudProviderId, clusterId, resourceName,
                    billingModel, availabilityZoneType, count);
        }
    }
}
