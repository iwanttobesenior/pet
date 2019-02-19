package org.example.application.domain.dto.base;

import org.example.application.domain.entity.base.AbstractEntity;

/**
 * Base class for all DTO
 * provide general functionality
 *
 * @author Kul'baka Alex
 */
public abstract class AbstractDTO<T extends AbstractEntity> {

    private long id;

    /**
     * Entity -> DTO transformation
     *
     * @param entity
     */
    public void transform(final T entity) {
        id = entity.getId();
    }

    /**
     * DTO -> Entity untransformed
     *
     * @param entity
     * @return Entity
     */
    public T untransform(final T entity) {
        entity.setId(getId());
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
