package com.redhat.services.ffm.ams.infra.auth.exceptions;

/**
 * OidcTokensNotInitializedException is raised if the tokens are not initialized in the TokenProvider.
 */
public class OidcTokensNotInitializedException extends RuntimeException {

    public OidcTokensNotInitializedException(String message) {
        super(message);
    }

    public OidcTokensNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

}
