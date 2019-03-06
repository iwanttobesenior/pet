package org.example.persistence.infrastructure.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * This annotation suggests CDI container(for example, Weld) to inject hibernate-related
 * dependencies
 *
 * @author Kul'baka Alex
 * @see org.example.persistence.repository.geography.impl.hibernate.HibernateCityRepository
 */
@Qualifier
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseSourceHibernateImpl {
    /*NOP*/
}
