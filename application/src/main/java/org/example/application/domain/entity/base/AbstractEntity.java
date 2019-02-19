package org.example.application.domain.entity.base;

import java.util.Objects;

/**
 * base abstract class for all business entities
 *
 * @author Kul'baka A.
 */
public abstract class AbstractEntity {

    /**
     * unique entity identifier
     */
    private long id;

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
