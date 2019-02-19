package org.example.application.infrastructure.transformation.annotation;

import org.example.application.infrastructure.util.transformation.ReflectionUtil;

import java.lang.annotation.*;

/**
 * Custom annotation accepting on {@link java.lang.reflect.Field}
 * in order to skip it,when need to convert DTO<->ENTITY
 * by
 * {@link ReflectionUtil}
 *
 * @author Kul'baka Alex
 * @see org.example.application.domain.dto.geography.CityDTO
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Ephemeral {
}
