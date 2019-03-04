package org.example.service.service.infrastructure.transformation.impl;

import org.example.service.rest.dto.base.AbstractDTO;
import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.infrastructure.util.check.Verifications;
import org.example.application.infrastructure.util.common.CommonUtil;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.example.service.service.infrastructure.transformation.ITransformer;
import org.example.service.service.infrastructure.transformation.cache.CacheFieldProvider;
import org.example.service.service.infrastructure.transformation.cache.FieldProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

/**
 * Implementation of {@link ITransformer} provide default transformation engine
 * that uses {@link ReflectionUtil} to transform objects
 * <p>
 * type of {@code E} means Entity
 * type of {@code D} means DTO
 *
 * @author Kul'baka Alex
 */
@Named
public final class SimpleDTOTransformer implements ITransformer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDTOTransformer.class);
    private final FieldProvider provider;

    public SimpleDTOTransformer() {
        this.provider = new CacheFieldProvider();
    }

    // TODO: 14.02.2019 LOGGING via AOP
    @Override
    public <E extends AbstractEntity, D extends AbstractDTO<E>> D transform
    (final E entity, final Class<D> clazz) {
        Verifications.verifyArg(entity, clazz);

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
        Verifications.verifyArg(dto, clazz);

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
