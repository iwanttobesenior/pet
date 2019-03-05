package org.example.rest.configuration;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.example.rest.swagger.SwaggerConfiguration;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Configuration class for jersey front-servlet, that provide the base path to restful web services
 *
 * @author Kul'baka Alex
 */
@ApplicationPath("/rest")
// TODO: 01.03.2019 add correct contact email,git
@SwaggerDefinition
        (
                schemes = SwaggerDefinition.Scheme.HTTP,
                info = @Info
                        (
                                title = "Example",
                                version = "1.0.0",
                                description = "Kul'baka Alex Pet project",
                                contact = @Contact
                                        (
                                                name = "Kul'baka Alexander",
                                                email = "todo",
                                                url = "todo"
                                        )
                        )
        )
public final class JerseyConfig extends ResourceConfig {

    /**
     * {@code super} load configuration
     * Package that contain restful web services
     *
     * @see SwaggerConfiguration
     */
    public JerseyConfig() {
        packages("org.example.rest.service");

        new SwaggerConfiguration().initBeanConfig();

        /*
        resources that provide information of services
        */
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
