package org.example.application.infrastructure.exception.uncheked.communication;

import org.example.application.infrastructure.exception.uncheked.base.ApplicationException;

/**
 * in case any interaction with external API
 */
public class CommunicationException extends ApplicationException {

    public CommunicationException(String message) {
        super(message);
    }

    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
