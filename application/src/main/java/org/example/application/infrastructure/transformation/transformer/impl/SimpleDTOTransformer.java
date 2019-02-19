package org.example.application.infrastructure.transformation.transformer.impl;

import org.example.application.domain.dto.base.AbstractDTO;
import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.infrastructure.transformation.transformer.Transformer;
import org.example.application.infrastructure.transformation.transformer.cache.CacheFieldProvider;
import org.example.application.infrastructure.transformation.transformer.cache.FieldProvider;
import org.example.application.infrastructure.util.check.Verifications;
import org.example.application.infrastructure.util.common.CommonUtil;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link Transformer} provide default transformation engine
 * that uses {@link ReflectionUtil} to transform objects
 * <p>
 * type of {@code E} means Entity
 * type of {@code D} means DTO
 *
 * @author Kul'baka Alex
 */
public final class SimpleDTOTransformer implements Transformer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDTOTransformer.class);
    private final FieldProvider provider;

    public SimpleDTOTransformer() {
        this.provider = new CacheFieldProvider();
    }

    // TODO: 14.02.2019 LOGGING via AOP
    @Override
    public <E extends AbstractEntity, D extends AbstractDTO<E>> D transform
    (final E entity, final Class<D> clazz) {
        Verifications.checkArguments(entity, clazz);

        final D dto = ReflectionUtil.newInstance(clazz);

        ReflectionUtil.copyFields(entity, dto,
                provider.getFieldNames(entity.getClass(), clazz));
        dto.transform(entity);

        if (logger.isDebugEnabled()) {
            logger.debug("SimpleDTOTransformer.transform: {} DTO object",
                    CommonUtil.toString(dto));
        }

        return dto;
    }

    @Override
    public <E extends AbstractEntity, D extends AbstractDTO<E>> E untransform
            (final D dto, final Class<E> clazz) {
        Verifications.checkArguments(dto, clazz);

        final E entity = ReflectionUtil.newInstance(clazz);

        ReflectionUtil.copyFields(dto, entity,
                provider.getFieldNames(dto.getClass(), clazz));
        dto.untransform(entity);

        if (logger.isDebugEnabled()) {
            logger.debug("SimpleDTOTransformer.untransform: {} Entity object",
                    CommonUtil.toString(entity));
        }

        return entity;
    }
}
