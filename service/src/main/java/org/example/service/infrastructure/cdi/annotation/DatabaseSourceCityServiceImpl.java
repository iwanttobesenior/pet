package org.example.service.infrastructure.cdi.annotation;

import org.example.service.service.geography.ICityService;
import org.example.service.service.geography.impl.CityServiceImpl;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * This annotation suggests CDI container(for example, Weld) to inject impl of
 * {@link ICityService}
 * dependencies
 *
 * @author Kul'baka Alex
 * @see CityServiceImpl
 */
@Qualifier
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseSourceCityServiceImpl {
    /*NOP*/
}
