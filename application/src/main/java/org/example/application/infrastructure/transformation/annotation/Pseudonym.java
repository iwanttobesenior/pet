package org.example.application.infrastructure.transformation.annotation;

import java.lang.annotation.*;

/**
 * add alias to DTO field,which client will see
 *
 * @author Kul'baka Alex
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Pseudonym {

    String pseudonym();
}
