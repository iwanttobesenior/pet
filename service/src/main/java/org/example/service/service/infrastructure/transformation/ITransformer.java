package org.example.service.service.infrastructure.transformation;

import org.example.application.domain.dto.base.AbstractDTO;
import org.example.application.domain.entity.base.AbstractEntity;

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
