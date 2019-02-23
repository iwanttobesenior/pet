package org.example.application.domain.entity.base;

import javax.persistence.*;
import java.util.Objects;

/**
 * Base abstract class for all business entities
 * Provides unique {@code id} for all entities
 *
 * @author Kul'baka Alex
 */
@MappedSuperclass
public abstract class AbstractEntity {

    /**
     * Constant that provide root package for all entities of project
     */
    public static final String ENTITY_PACKAGE_NAME = "org.example.application.domain.entity";

    /**
     * unique entity identifier
     */
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
