package dev.bf2.ffm.ams.core.exceptions;

/**
 * CreationNotAllowedException is raised if the creation request fails.
 */
public class CreationNotAllowedException extends RuntimeException {

    public CreationNotAllowedException(String message) {
        super(message);
    }

    public CreationNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}