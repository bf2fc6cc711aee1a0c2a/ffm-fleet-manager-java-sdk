package com.redhat.services.ffm.ams.core;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tomakehurst.wiremock.WireMockServer;

public class AMSWiremockUtils {

    public static void stubTermsNotAccepted(WireMockServer server) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("account_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ACCOUNT_ID_STRING));
        body.set("organization_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ORGANIZATION_ID));
        body.set("redirect_url", JsonNodeFactory.instance.textNode(Constants.DEFAULT_REDIRECT_URL));
        body.set("terms_available", JsonNodeFactory.instance.booleanNode(true));
        body.set("terms_required", JsonNodeFactory.instance.booleanNode(true));

        server.stubFor(post(urlEqualTo(Constants.TERMS_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(body)
                        .withStatus(200)));
    }

    public static void stubTermsAccepted(WireMockServer server) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("account_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ACCOUNT_ID_STRING));
        body.set("organization_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ORGANIZATION_ID));
        body.set("redirect_url", JsonNodeFactory.instance.textNode(Constants.DEFAULT_REDIRECT_URL));
        body.set("terms_available", JsonNodeFactory.instance.booleanNode(true));
        body.set("terms_required", JsonNodeFactory.instance.booleanNode(false));

        server.stubFor(post(urlEqualTo(Constants.TERMS_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(body)
                        .withStatus(200)));
    }

    public static void stubCreationSuccessfull(WireMockServer server) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("allowed", JsonNodeFactory.instance.booleanNode(true));
        body.set("subscription", JsonNodeFactory.instance.objectNode().set("id",
                JsonNodeFactory.instance.textNode(Constants.DEFAULT_SUBSCRIPTION_ID)));

        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(body)
                        .withStatus(200)));
    }

    public static void stubCreationFailed(WireMockServer server) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("allowed", JsonNodeFactory.instance.booleanNode(false));

        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(body)
                        .withStatus(200)));
    }

    public static void stubDeletionSuccessfull(WireMockServer server, String subscriptionId) {
        server.stubFor(delete(urlEqualTo(Constants.SUBSCRIPTIONS_PATH + "/" + subscriptionId))
                .willReturn(aResponse().withStatus(200)));
    }

    public static void stubDeletionFailed(WireMockServer server, String subscriptionId) {
        server.stubFor(delete(urlEqualTo(Constants.SUBSCRIPTIONS_PATH + "/" + subscriptionId))
                .willReturn(aResponse().withStatus(404)));
    }

    public static void stubGetOrganizationById(WireMockServer server, String orgId) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ORGANIZATION_ID));

        server.stubFor(
                get(urlEqualTo(Constants.ORGANIZATIONS_PATH + "/" + orgId + "?fetchLabels=false&fetchCapabilities=false"))
                        .willReturn(aResponse()
                                .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                                .withJsonBody(body)
                                .withStatus(200)));
    }

    public static void stubGetOrganizationByIdNotFound(WireMockServer server, String orgId) {
        server.stubFor(
                get(urlEqualTo(Constants.ORGANIZATIONS_PATH + "/" + orgId + "?fetchLabels=false&fetchCapabilities=false"))
                        .willReturn(aResponse()
                                .withStatus(404)));
    }

    public static void stubOrganizationQuota(WireMockServer server, String organizationId, String product, String resourceName,
            Integer allowed) {
        ObjectNode quotaCost = JsonNodeFactory.instance.objectNode();
        quotaCost.set("allowed", JsonNodeFactory.instance.numberNode(allowed));

        ObjectNode relatedResource = JsonNodeFactory.instance.objectNode();
        relatedResource.set("product", JsonNodeFactory.instance.textNode(product));
        relatedResource.set("resource_name", JsonNodeFactory.instance.textNode(resourceName));

        quotaCost.set("related_resources", JsonNodeFactory.instance.arrayNode().add(relatedResource));

        ObjectNode body = JsonNodeFactory.instance.objectNode();
        body.set("items", JsonNodeFactory.instance.arrayNode().add(quotaCost));

        server.stubFor(get(urlEqualTo(Constants.QUOTA_COST_PATH + "?search=" + organizationId
                + "&fetchRelatedResources=true&fetchCloudAccounts=false"))
                        .willReturn(aResponse()
                                .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                                .withJsonBody(body)
                                .withStatus(200)));
    }

    public static void stubTermsReturn500(WireMockServer server) {
        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withStatus(500)));
    }
}
