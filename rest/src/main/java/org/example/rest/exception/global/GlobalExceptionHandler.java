package org.example.rest.exception.global;

import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Global exception handler
 */
@Provider
public final class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());
    private final Response SERVER_ERROR;

    public GlobalExceptionHandler() {
        SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response toResponse(final Exception exception) {
        logger.error(exception.getMessage(), exception);
        return SERVER_ERROR;
    }
}
