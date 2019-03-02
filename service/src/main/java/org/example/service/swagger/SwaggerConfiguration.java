package org.example.service.swagger;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * Configuration class for {@code Swagger}
 *
 * @author Kul'baka Alex
 */
public final class SwaggerConfiguration {

    public final void initBeanConfig() {
        final BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8888");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("org.example.service.rest");
        beanConfig.setScan(true);
    }
}
