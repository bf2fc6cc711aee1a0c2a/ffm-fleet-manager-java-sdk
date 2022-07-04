package com.redhat.services.ffm.ams.core;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tomakehurst.wiremock.WireMockServer;

public class AMSWiremockUtils {

    public static void stubTermsNotAccepted(WireMockServer server) {
        ObjectNode connector = JsonNodeFactory.instance.objectNode();
        connector.set("account_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ACCOUNT_ID_STRING));
        connector.set("organization_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ORGANIZATION_ID));
        connector.set("redirect_url", JsonNodeFactory.instance.textNode(Constants.DEFAULT_REDIRECT_URL));
        connector.set("terms_available", JsonNodeFactory.instance.booleanNode(true));
        connector.set("terms_required", JsonNodeFactory.instance.booleanNode(true));

        server.stubFor(post(urlEqualTo(Constants.TERMS_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(connector)
                        .withStatus(200)));
    }

    public static void stubTermsAccepted(WireMockServer server) {
        ObjectNode connector = JsonNodeFactory.instance.objectNode();
        connector.set("account_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ACCOUNT_ID_STRING));
        connector.set("organization_id", JsonNodeFactory.instance.textNode(Constants.DEFAULT_ORGANIZATION_ID));
        connector.set("redirect_url", JsonNodeFactory.instance.textNode(Constants.DEFAULT_REDIRECT_URL));
        connector.set("terms_available", JsonNodeFactory.instance.booleanNode(true));
        connector.set("terms_required", JsonNodeFactory.instance.booleanNode(false));

        server.stubFor(post(urlEqualTo(Constants.TERMS_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(connector)
                        .withStatus(200)));
    }

    public static void stubCreationSuccessfull(WireMockServer server) {
        ObjectNode connector = JsonNodeFactory.instance.objectNode();
        connector.set("allowed", JsonNodeFactory.instance.booleanNode(true));
        connector.set("subscription", JsonNodeFactory.instance.objectNode().set("id",
                JsonNodeFactory.instance.textNode(Constants.DEFAULT_SUBSCRIPTION_ID)));

        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(connector)
                        .withStatus(200)));
    }

    public static void stubCreationFailed(WireMockServer server) {
        ObjectNode connector = JsonNodeFactory.instance.objectNode();
        connector.set("allowed", JsonNodeFactory.instance.booleanNode(false));

        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withHeader(Constants.CONTENT_TYPE_HEADER, Constants.JSON_CONTENT_TYPE)
                        .withJsonBody(connector)
                        .withStatus(200)));
    }

    public static void stubTermsReturn500(WireMockServer server) {
        server.stubFor(post(urlEqualTo(Constants.CLUSTER_AUTHORIZATION_PATH))
                .willReturn(aResponse()
                        .withStatus(500)));
    }
}
