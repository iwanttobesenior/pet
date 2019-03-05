package org.example.rest.infrastructure.transformation;

import org.example.application.domain.entity.base.AbstractEntity;
import org.example.rest.dto.base.AbstractDTO;

/**
 * Transformation API
 *
 * @author Kul'baka Alex
 */
public interface ITransformer {

    <E extends AbstractEntity, D extends AbstractDTO<E>> D transform
            (final E entity, final Class<D> clazz);

    <E extends AbstractEntity, D extends AbstractDTO<E>> E untransform
            (final D dto, final Class<E> clazz);
}
