package org.example.application.infrastructure.transformation.transformer.cache;

import org.example.application.infrastructure.util.transformation.ReflectionUtil;

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
