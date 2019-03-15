package org.example.application.domain.entity.base;

import org.example.application.domain.entity.person.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Fix the creation or updating time
 * also
 * Fix by who make creation or updating action
 *
 * @author Kul'baka Alex
 */
@MappedSuperclass
public abstract class AuditEntity extends AbstractEntity {
    /**
     * Name of field that need to change state,when hibernate uses {@code this} for interception
     */
    public static final String FIELD_CREATED_AT = "createdAt";

    /**
     * Timestamp of entity creation
     */
    private LocalDateTime createdAt;
    /**
     * Timestamp of last entity modifications
     */
    private LocalDateTime updatedAt;

    /**
     * Who created current entity
     */
    private User createdBy;
    /**
     * Who updated current entity
     */
    private User updatedBy;

    /**
     * Field that will not be involved with update statement
     * can't be {@code null}
     */
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Field that will no be involved with insert statement
     * should be {@code null} if no update action was yet
     */
    @Column(name = "UPDATE_AT", nullable = true, insertable = false)
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATE_BY", updatable = false)
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATE_BY", insertable = false)
    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
}
