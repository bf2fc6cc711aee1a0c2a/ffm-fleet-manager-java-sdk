package com.redhat.services.ffm.ams.core.exceptions;

public class CreationNotAllowedException extends RuntimeException {

    public CreationNotAllowedException(String message) {
        super(message);
    }

    public CreationNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}