package edu.unomaha.docusign.controller;

/**
 * Unchecked exception caused by examples.
 */
public class Exception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message and cause.
     * @param message the detail message, which is kept as member
     * @param cause the cause, which is saved as member
     */
    public Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
