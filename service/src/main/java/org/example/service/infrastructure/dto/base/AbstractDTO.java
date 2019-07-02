package org.example.service.infrastructure.dto.base;

import org.example.application.domain.entity.base.AbstractEntity;
import org.example.service.infrastructure.transformation.ITransformable;

/**
 * Base class for all DTO
 * provide general functionality
 *
 * @author Kul'baka Alex
 */
public abstract class AbstractDTO<T extends AbstractEntity> implements ITransformable<T> {

    private long id;

    /**
     * Entity -> DTO reflection
     *
     * @param entity
     */
    @Override
    public void transform(final T entity) {
        id = entity.getId();
    }

    /**
     * DTO -> Entity untransformed
     *
     * @param entity
     * @return Entity
     */
    @Override
    public T unTransform(final T entity) {
        entity.setId(getId());
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }
}
