package org.example.application.infrastructure.util.reflection;

import org.example.application.domain.entity.base.AbstractEntity;
import org.example.application.infrastructure.exception.uncheked.configuration.ConfigurationException;
import org.example.application.infrastructure.exception.uncheked.execution.InvalidArgumentException;
import org.example.application.infrastructure.transformation.annotation.Ephemeral;
import org.example.application.infrastructure.util.check.Verifications;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Util class for reflection Entity<->DTO
 *
 * @author Kul'baka Alex
 * @see org.example.application.infrastructure.transformation.annotation.Ephemeral
 */
public final class ReflectionUtil {

    private static final int CALLER_CLASS_INDEX = 1;

    /**
     * you should't create utility instance
     * also
     * you should't extends utility {@code class}
     *
     * @throws UnsupportedOperationException if someone tries create instant of this class via reflection
     */
    private ReflectionUtil() {
        throw new UnsupportedOperationException("you should't create instance of utility class");
    }

    /**
     * Returns list of fields with identical names irregardless of their
     * modifiers
     * Ignore filed if it marked by {@link Ephemeral} annotation
     * Skip {@code static}{@code final} fields
     */
    // TODO: 10.02.2019 handle annotations...
    public static List<String> findSimilarFields(final Class<?> aClass, final Class<?> bClass) {
        try {

            final var fields = collectFieldsAcrossAllHierarchy(aClass);

            List<String> targetFields = Stream.of(bClass.getDeclaredFields())
                    .filter(field -> !field.isAnnotationPresent(Ephemeral.class))
                    .map(Field::getName)
                    .collect(Collectors.toList());
            return fields.stream()
                    .filter(field -> !field.isAnnotationPresent(Ephemeral.class))
                    .filter(field -> !Modifier.isStatic(field.getModifiers())
                            && !Modifier.isFinal(field.getModifiers()))
                    .map(Field::getName)
                    .filter(targetFields::contains)
                    .collect(Collectors.toList());

        } catch (SecurityException e) {
            throw new ConfigurationException(e);
        }
    }


    /**
     * Creates an instance of the specified {@code class} This method throws unchecked
     * exception if creation fails
     *
     * @throws InvalidArgumentException if any exception occur
     */
    public static <T> T newInstance(final Class<T> byClass) {
        try {
            return byClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException e) {
            throw new InvalidArgumentException(e);
        }
    }

    /**
     * Copy specified fields values from source to destination objects
     *
     * @param src    source object
     * @param dest   destination object
     * @param fields to copy
     */
    public static void copyFields(Object src, Object dest, List<String> fields) {
        Verifications.verifyArg(src != null, "Source object is not initialized");
        Verifications.verifyArg(dest != null, "Destination object is not initialized");
        try {
            for (String field : fields) {
                final var fld = collectFieldsAcrossAllHierarchyByFieldName(src.getClass(), field);
                if (fld != null) {
                    fld.setAccessible(true);
                    final var value = fld.get(src);

                    final var fldDest = collectFieldsAcrossAllHierarchyByFieldName(dest.getClass(), field);

                    if (fldDest != null) {
                        fldDest.setAccessible(true);
                        fldDest.set(dest, value);
                    }
                }
            }
        } catch (SecurityException | ReflectiveOperationException | IllegalArgumentException e) {
            throw new ConfigurationException(e);
        }
    }

    /**
     * Gather all fields from current to parent {@code class}
     *
     * @return List of declared fields
     */
    public static List<Field> collectFieldsAcrossAllHierarchy(Class<?> clazz) {
        final var allFields = new ArrayList<Field>();
        while (clazz != null) {
            allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return allFields;
    }

    /**
     * Returns class field by its name. This method supports base classes as well
     *
     * @return Field by {@code fieldName}
     */
    public static <T> Field collectFieldsAcrossAllHierarchyByFieldName
    (final Class<T> clazz, final String fieldName) {
        Class<?> current = clazz;
        while (current != null) {
            try {
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException | SecurityException e) {
                current = current.getSuperclass();
            }
        }
        throw new ConfigurationException("no such fields: " + fieldName + " in the class " + clazz);
    }

    /**
     * Get all classes marked by {@code annotation}
     * From {@link org.example.application.domain.entity} package
     *
     * @param annotation which marked needed classes
     * @return Set of found classes
     */
    public static Set<Class<?>> getClassesByAnnotation(final Class<? extends Annotation> annotation) {
        return getClassesFromSpecifiedPackageByGivenAnnotation(AbstractEntity.ENTITY_PACKAGE_NAME, annotation);
    }

    /**
     * Get all classes marked by {@code annotation}
     * from given {@code package}
     *
     * @param annotation which marked needed classes
     * @param pack       wherein should look for suitable classes
     * @return Set of found classes
     */
    public static Set<Class<?>> getClassesFromSpecifiedPackageByGivenAnnotation(final String pack, final Class<? extends Annotation> annotation) {
        var reflections = new Reflections(pack);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    /**
     * Provide {@code class} name wherein this method was invoked
     * note:BAD PRACTICE
     *
     * @return full {@code class} name
     */
    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return e.getStackTrace()[CALLER_CLASS_INDEX].getClassName();
        }
    }
}
