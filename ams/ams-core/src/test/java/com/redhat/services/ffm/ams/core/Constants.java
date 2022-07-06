package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.client.models.ClusterAuthorizationRequest;
import com.redhat.services.ffm.ams.core.models.AccountInfo;
import com.redhat.services.ffm.ams.core.models.TermRequest;

public class Constants {

    // HTTP headers constants
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String JSON_CONTENT_TYPE = "application/json";

    // AMS Constants
    public static final String TERMS_PATH = "/api/authorizations/v1/terms_review";
    public static final String CLUSTER_AUTHORIZATION_PATH = "/api/accounts_mgmt/v1/cluster_authorizations";

    // Tests constants
    public static final ClusterAuthorizationRequest.ProductIdEnum DEFAULT_PRODUCT_ID = ClusterAuthorizationRequest.ProductIdEnum.OCP;
    public static final String DEFAULT_ACCOUNT_ID_STRING = "0";
    public static final Long DEFAULT_ACCOUNT_ID = 0L;
    public static final Boolean DEFAULT_ADMIN_ROLE = false;
    public static final String DEFAULT_ORGANIZATION_ID = "organizationId";
    public static final String DEFAULT_REDIRECT_URL = "http://test.com";
    public static final String DEFAULT_USERNAME = "username";
    public static final String DEFAULT_RESOURCE_NAME = "name";
    public static final String DEFAULT_CLOUD_PROVIDER_ID = "aws";
    public static final String DEFAULT_CLUSTER_ID = "clusterId";
    public static final String DEFAULT_BILLING_MODEL = "marketPlace";
    public static final String DEFAULT_AVAILABILITY_ZONE_TYPE = "single";
    public static final String DEFAULT_SUBSCRIPTION_ID = "subscriptionId";
    public static final String DEFAULT_TERM_EVENT_CODE = "onlineService"; // "register" in prod
    public static final String DEFAULT_TERM_SITE_CODE = "ocm";
    public static final Integer DEFAULT_COUNT = 1;

    public static final AccountInfo DEFAULT_ACCOUNT_INFO = new AccountInfo.Builder()
            .withAccountId(DEFAULT_ACCOUNT_ID)
            .withAccountUsername(DEFAULT_USERNAME)
            .withAdminRole(DEFAULT_ADMIN_ROLE)
            .withOrganizationId(DEFAULT_ORGANIZATION_ID)
            .build();
    public static final TermRequest DEFAULT_TERMS_REQUEST = new TermRequest.Builder()
            .withEventCode(DEFAULT_TERM_EVENT_CODE)
            .withSiteCode(DEFAULT_TERM_SITE_CODE)
            .build();
}
