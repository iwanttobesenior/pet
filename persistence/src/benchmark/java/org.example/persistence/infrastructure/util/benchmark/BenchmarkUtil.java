package org.example.persistence.infrastructure.util.benchmark;

/**
 * Packages name holder
 *
 * @author Kul'baka Alex
 */
public final class BenchmarkUtil {

    public static final String PACKAGE_THAT_CONTAIN_ENTITY_CLASSES = "org.example.application.domain.entity";
    public static final String PACKAGE_THAT_CONTAIN_REPOSITORY_CLASSES = "org.example.persistence.repository";

    public static final String CITY_REPOSITORY = "org.example.persistence.repository.geography.ICityRepository";
    public static final String ENTITY = "javax.persistence.Entity";
    public static final String BASE_HIBERNATE_REPOSITORY = "org.example.persistence.repository.base.BaseHibernateRepository";

    /**
     * @throws UnsupportedOperationException if someone tries create instant of this class via reflection
     */
    private BenchmarkUtil() {
        throw new UnsupportedOperationException("you should't create instance of utility class");
    }
}
