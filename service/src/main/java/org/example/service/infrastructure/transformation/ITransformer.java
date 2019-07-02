package org.example.service.infrastructure.transformation;

import org.example.application.domain.entity.base.AbstractEntity;

/**
 * Represents reflection engine to convert business entities
 * into DTO objects
 *
 * @author Kul'baka Alex
 */
public interface ITransformer {

    /**
     * Converts specified entity into DTO object
     *
     * @param entity
     * @param clz
     */
    <T extends AbstractEntity, P extends ITransformable<T>> P transform(final T entity, final Class<P> clz);

    /**
     * Converts specified DTO object into business entity
     *
     * @param dto
     * @param clz
     */
    <T extends AbstractEntity, P extends ITransformable<T>> T unTransform(final P dto, final Class<T> clz);

    /**
     * Converts specified entity into existing DTO object
     *
     * @param entity
     * @param obj
     */
    <T extends AbstractEntity, P extends ITransformable<T>> void transform(final T entity, final P obj);
}
