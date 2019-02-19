package org.example.application.infrastructure.exception.uncheked.persistence;

import org.example.application.infrastructure.exception.uncheked.base.ApplicationException;

/**
 * in case any data base exception
 */
public class PersistenceException extends ApplicationException {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
