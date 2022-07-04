package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;

public class Constants {
    // HTTP headers constants
    static final String CONTENT_TYPE_HEADER = "Content-Type";
    static final String JSON_CONTENT_TYPE = "application/json";

    // AMS Constants
    static final String TERMS_PATH = "/api/authorizations/v1/terms_review";
    static final String CLUSTER_AUTHORIZATION_PATH = "/api/accounts_mgmt/v1/cluster_authorizations";

    // Tests constants
    static final ClusterAuthorizationRequest.ProductIdEnum DEFAULT_PRODUCT_ID = ClusterAuthorizationRequest.ProductIdEnum.OCP;
    static final String DEFAULT_ACCOUNT_ID_STRING = "0";
    static final Long DEFAULT_ACCOUNT_ID = 0L;
    static final String DEFAULT_ORGANIZATION_ID = "organizationId";
    static final String DEFAULT_REDIRECT_URL = "http://test.com";
    static final String DEFAULT_USERNAME = "username";
    static final String DEFAULT_RESOURCE_NAME = "name";
    static final String DEFAULT_CLOUD_PROVIDER_ID = "aws";
    static final String DEFAULT_CLUSTER_ID = "clusterId";
    static final String DEFAULT_BILLING_MODEL = "marketPlace";
    static final String DEFAULT_AVAILABILITY_ZONE_TYPE = "single";
    static final String DEFAULT_SUBSCRIPTION_ID = "subscriptionId";
    static final String DEFAULT_TERM_EVENT_CODE = "onlineService"; // "register" in prod
    static final String DEFAULT_TERM_SITE_CODE = "ocm";
    static final Integer DEFAULT_COUNT = 1;
}
