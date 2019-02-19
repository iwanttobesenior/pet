package org.example.application.infrastructure.transformation.transformer;

import org.example.application.domain.dto.base.AbstractDTO;
import org.example.application.domain.entity.base.AbstractEntity;

/**
 * Transformation API
 *
 * @author Kul'baka Alex
 * @see org.example.application.infrastructure.transformation.transformer.impl.SimpleDTOTransformer
 */
public interface Transformer {

    <E extends AbstractEntity, D extends AbstractDTO<E>> D transform
            (final E entity, final Class<D> clazz);

    <E extends AbstractEntity, D extends AbstractDTO<E>> E untransform
            (final D dto, final Class<E> clazz);
}
