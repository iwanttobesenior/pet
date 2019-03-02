package org.example.service.rest.base;

import javax.ws.rs.core.Response;

/**
 * Base class for all rest services
 * provide general response status
 *
 * @author Kul'baka Alex
 */
public abstract class AbstractResource {

    /**
     * Http response that should be returned if data not found
     */
    protected final Response NOT_FOUND;

    /**
     * Http response that should be returned if request has incorrect format
     */
    protected final Response BAD_REQUEST;

    public AbstractResource() {
        NOT_FOUND = Response.status(Response.Status.NOT_FOUND).build();
        BAD_REQUEST = Response.status(Response.Status.BAD_REQUEST).build();
    }

    /**
     * Return result of services as {@link Response} instance
     *
     * @param result
     * @return Response
     */
    protected Response ok(final Object result) {
        return Response.ok(result).build();
    }
}
