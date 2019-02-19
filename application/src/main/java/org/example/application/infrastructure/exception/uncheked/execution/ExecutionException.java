package org.example.application.infrastructure.exception.uncheked.execution;

import org.example.application.infrastructure.exception.uncheked.base.ApplicationException;

/**
 * in case program work flow exception
 */
public class ExecutionException extends ApplicationException {

    public ExecutionException(String message) {
        super(message);
    }

    public ExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecutionException(Throwable cause) {
        super(cause);
    }
}
