package com.redhat.services.ffm.ams.core.models;

public class CreateResourceRequest {

    private AccountInfo accountInfo;
    private TermRequest termRequest;
    private String productId;
    private String cloudProviderId;
    private String clusterId;
    private String resourceName;
    private String billingModel;
    private String availabilityZoneType;
    private Integer count;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public TermRequest getTermRequest() {
        return termRequest;
    }

    public void setTermRequest(TermRequest termRequest) {
        this.termRequest = termRequest;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCloudProviderId() {
        return cloudProviderId;
    }

    public void setCloudProviderId(String cloudProviderId) {
        this.cloudProviderId = cloudProviderId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getBillingModel() {
        return billingModel;
    }

    public void setBillingModel(String billingModel) {
        this.billingModel = billingModel;
    }

    public String getAvailabilityZoneType() {
        return availabilityZoneType;
    }

    public void setAvailabilityZoneType(String availabilityZoneType) {
        this.availabilityZoneType = availabilityZoneType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
