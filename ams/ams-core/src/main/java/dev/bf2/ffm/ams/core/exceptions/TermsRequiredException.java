package dev.bf2.ffm.ams.core.exceptions;

/**
 * TermsRequiredException is raised if the user has not accepted the terms.
 */
public class TermsRequiredException extends RuntimeException {

    public TermsRequiredException(String message) {
        super(message);
    }

    public TermsRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
