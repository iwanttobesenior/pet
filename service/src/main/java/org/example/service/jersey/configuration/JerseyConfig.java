package org.example.service.jersey.configuration;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Configuration class for jersey front-servlet, that provide the base path to restful web services
 *
 * @author Kul'baka Alex
 */
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    /**
     * Package that contain restful web services
     */
    public JerseyConfig() {
        packages("org.example.service.rest");
    }
}
