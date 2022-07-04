package com.redhat.services.ffm.ams.core.exceptions;

public class TermsRequiredException extends RuntimeException {

    public TermsRequiredException(String message) {
        super(message);
    }

    public TermsRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
