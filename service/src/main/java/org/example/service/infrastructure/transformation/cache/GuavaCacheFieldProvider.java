package org.example.service.infrastructure.transformation.cache;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;

import java.util.List;

/**
 * Cache implementation of {@link FieldProvider} via {@code com.google.common} library
 *
 * @author Kul'baka ALex
 */
public class GuavaCacheFieldProvider extends FieldProvider {

    private final ListMultimap<String, String> cache;

    public GuavaCacheFieldProvider() {
        this.cache = ArrayListMultimap.create();
    }

    @Override
    public List<String> getFieldNames(final Class<?> src, final Class<?> dest) {
        final String key = dest.getSimpleName() + src.getSimpleName();

        List<String> fields = cache.get(key);
        if (fields == null) {
            fields = ReflectionUtil.findSimilarFields(src, dest);
            cache.putAll(key, fields);
        }

        return fields;
    }
}
