package org.example.service.infrastructure.transformation.cache;

import org.example.application.infrastructure.util.reflection.ReflectionUtil;

import java.util.List;

/**
 * Base functionality of the field preparation
 *
 * @author Kul'baka Alex
 */
public class FieldProvider {

    public List<String> getFieldNames(final Class<?> src, final Class<?> dest) {
        return ReflectionUtil.findSimilarFields(src, dest);
    }
}
