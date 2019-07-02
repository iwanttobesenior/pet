package org.example.service.infrastructure.transformation.impl;

import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.infrastructure.util.check.Verifications;
import org.example.application.infrastructure.util.common.CommonUtil;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.example.service.infrastructure.cdi.annotation.SimpleTransformerImpl;
import org.example.service.infrastructure.transformation.ITransformable;
import org.example.service.infrastructure.transformation.ITransformer;
import org.example.service.infrastructure.transformation.cache.CacheFieldProvider;
import org.example.service.infrastructure.transformation.cache.FieldProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

/**
 * Implementation of {@link ITransformer} provide default reflection engine
 * that uses {@link ReflectionUtil} to transform objects
 * <p>
 * type of {@code E} means Entity
 * type of {@code D} means DTO
 *
 * @author Kul'baka Alex
 */
@Named
@SimpleTransformerImpl
public final class SimpleDTOTransformer implements ITransformer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDTOTransformer.class);
    private final FieldProvider provider;

    public SimpleDTOTransformer() {
        this.provider = new CacheFieldProvider();
    }

    // TODO: 14.02.2019 LOGGING
    @Override
    public <E extends AbstractEntity, D extends ITransformable<E>> D transform
    (final E entity, final Class<D> clazz) {
        Verifications.verifyArg(entity, clazz);

        return handleTransformation(entity, ReflectionUtil.newInstance(clazz));
    }

    @Override
    public <E extends AbstractEntity, D extends ITransformable<E>> E unTransform
            (final D dto, final Class<E> clazz) {
        Verifications.verifyArg(dto, clazz);

        final E entity = ReflectionUtil.newInstance(clazz);

        ReflectionUtil.copyFields(dto, entity,
                provider.getFieldNames(dto.getClass(), clazz));
        dto.unTransform(entity);

        if (logger.isDebugEnabled()) {
            logger.debug("SimpleDTOTransformer.unTransform: {} Entity object",
                    CommonUtil.toString(entity));
        }

        return entity;
    }

    @Override
    public <T extends AbstractEntity, P extends ITransformable<T>> void transform(final T entity, final P destination) {
        Verifications.verifyArg(entity, entity + " Source reflection object is not initialized");
        Verifications.verifyArg(destination, destination + " Destination object is not initialized");

        handleTransformation(entity, destination);
    }

    private <T extends AbstractEntity, P extends ITransformable<T>> P handleTransformation(final T entity, final P destination) {
        ReflectionUtil.copyFields(entity, destination, provider.getFieldNames(entity.getClass(), destination.getClass()));
        destination.transform(entity);

        if (logger.isDebugEnabled()) {
            logger.debug("SimpleDTOTransformer.transform: {} DTO object", CommonUtil.toString(destination));
        }
        return destination;
    }
}
