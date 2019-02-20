package org.example.service.service.infrastructure.transformation.cache;

import org.example.application.infrastructure.util.transformation.ReflectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class caches field names for each transformation pair
 *
 * @author Kul'baka Alex
 * @see FieldProvider
 */
public final class CacheFieldProvider extends FieldProvider {

    /**
     * Mapping between transformation pair({@code src} class and {@code dest} class names)
     * and field list
     */
    private final Map<String, List<String>> cache;

    public CacheFieldProvider() {
        this.cache = new HashMap<>();
    }

    /**
     * Returns list of similar field names for source/destination classes
     */
    @Override
    public List<String> getFieldNames(final Class<?> src, final Class<?> dest) {
        final var key = src.getName() + dest.getName();
        var fields = cache.get(key);
        if (fields == null) {
            fields = ReflectionUtil.findSimilarFields(src, dest);
            cache.put(key, fields);
        }
        return fields;
    }
}
