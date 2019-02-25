package org.example.application.infrastructure.exception.uncheked.execution;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This exception will be throw when any model turn out not valid
 */
public class ValidationException extends ExecutionException {

    public ValidationException(final String message) {
        super(message);
    }

    public ValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ValidationException(final Throwable cause) {
        super(cause);
    }

    public <T> ValidationException(final String msg, final Set<ConstraintViolation<T>> constraintViolations) {
        super(msg + " : " + constraintViolations
                .stream()
                .map(constraint -> constraint.getPropertyPath() + ":" + constraint.getMessage())
                .collect(Collectors.joining(",")));
    }
}
