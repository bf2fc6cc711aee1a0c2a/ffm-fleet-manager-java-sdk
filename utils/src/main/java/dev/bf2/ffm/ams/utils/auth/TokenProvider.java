package dev.bf2.ffm.ams.utils.auth;

/**
 * The HTTP client needs to attach a valid token to the requests. This TokenProvider aims to expose such methods.
 * The AbstractTokenProvider aims to provide the functionality using quarkus-oidc.
 */
public interface TokenProvider {

    /**
     * Gets the name of the token provider.
     *
     * @return the token provider name.
     */
    String getName();

    /**
     * Gets the token to attach to a request.
     *
     * @return the token.
     */
    String getToken();
}
