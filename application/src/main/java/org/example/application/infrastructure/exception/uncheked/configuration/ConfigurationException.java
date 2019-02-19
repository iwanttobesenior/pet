package org.example.application.infrastructure.exception.uncheked.configuration;

import org.example.application.infrastructure.exception.uncheked.base.ApplicationException;

/**
 * in case any configuration exception
 */
public class ConfigurationException extends ApplicationException {

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(Throwable cause) {
        super(cause);
    }
}
