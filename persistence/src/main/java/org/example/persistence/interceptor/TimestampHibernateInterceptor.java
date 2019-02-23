package org.example.persistence.interceptor;

import org.apache.commons.lang3.ArrayUtils;
import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.domain.entity.base.AuditEntity;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Hibernate interceptor implementation via base {@link EmptyInterceptor} stub
 *
 * @author Kul'baka Alex
 * @see org.hibernate.Interceptor
 */
// TODO: 22.02.2019 LOG!
public class TimestampHibernateInterceptor extends EmptyInterceptor {

    /**
     * Intercept {@code save} operation
     * set {@code now} time
     */
    @Override
    public boolean onSave(final Object entity, final Serializable id,
                          final Object[] state, final String[] propertyNames, final Type[] types) {

        int index = ArrayUtils.indexOf(propertyNames, AuditEntity.FIELD_CREATED_AT);
        if (index >= 0) {
            state[index] = LocalDateTime.now();
            return true;
        }
        return false;
    }
}
