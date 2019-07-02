package org.example.rest.exception.validation;

import org.example.application.infrastructure.exception.uncheked.execution.ValidationException;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

    private static final Logger logger = LoggerFactory
            .getLogger(ReflectionUtil
                    .getCurrentClassName());

    @Override
    public Response toResponse(final ValidationException e) {
        logger.error(e.getMessage(), e);
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
