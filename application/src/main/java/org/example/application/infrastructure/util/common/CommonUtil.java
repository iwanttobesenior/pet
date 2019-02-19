package org.example.application.infrastructure.util.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 * also
 * provide protective programming
 *
 * @author Kul'bala Alex
 */
public final class CommonUtil {

    private CommonUtil() {
    }

    /**
     * Returns non-{@code null} unmodifiable copy of the source {@code Set}
     */
    public static <T> Set<T> getUnmodifiableSet(final Set<T> source) {
        return Collections
                .unmodifiableSet(Optional.ofNullable(source)
                        .orElse(Collections.emptySet()));
    }

    /**
     * Returns non-{@code null} unmodifiable copy of the source {@code List}
     */
    public static <T> List<T> getUnmodifiableList(final List<T> source) {
        return Collections
                .unmodifiableList(Optional.ofNullable(source)
                        .orElse(Collections.emptyList()));
    }

    public static String toString(final Object arg) {
        return ReflectionToStringBuilder.toString(arg, ToStringStyle.JSON_STYLE);
    }
}
