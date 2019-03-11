package org.example.service.infrastructure.cdi.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * This annotation suggests CDI container(for example, Weld) to inject impl of
 * {@link org.example.service.service.ICityService}
 * dependencies
 *
 * @author Kul'baka Alex
 * @see org.example.service.service.impl.CityServiceImpl
 */
@Qualifier
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseSourceCityServiceImpl {
    /*NOP*/
}
