package org.example.application.infrastructure.exception.uncheked.execution;

/**
 * in case any passed argument not valid
 */
public class InvalidArgumentException extends ExecutionException {

    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(Exception e) {
        super(e);
    }

    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
