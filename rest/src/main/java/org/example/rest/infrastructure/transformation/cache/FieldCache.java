package org.example.rest.infrastructure.transformation.cache;

import org.example.application.infrastructure.util.transformation.ReflectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple caching.
 *
 * @author Kul'baka Alex
 */
public class FieldCache {

    private Map<String, List<String>> cache;

    public FieldCache() {
        this.cache = new HashMap<>();
    }

    public List<String> getCachedFieldNames(final Class<?> source, final Class<?> dest) {
        final var key = source.getSimpleName() + dest.getSimpleName();
        List<String> fields = cache.get(key);
        if (fields == null) {
            fields = ReflectionUtil.findSimilarFields(source, dest);
            cache.put(key, fields);
        }

        return fields;
    }
}
