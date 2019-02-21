package org.example.application.domain.entity.base;

import org.example.application.domain.entity.person.Account;

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
     * Timestamp of entity creation
     */
    private LocalDateTime createAt;
    /**
     * Timestamp of last entity modifications
     */
    private LocalDateTime updateAt;

    /**
     * Who created current entity
     */
    private Account createBy;
    /**
     * Who updated current entity
     */
    private Account updateBy;

    /**
     * Field that will not be involved with update statement
     * can't be {@code null}
     */
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    /**
     * Field that will no be involved with insert statement
     * should be {@code null} if no update action was yet
     */
    @Column(name = "UPDATE_AT", nullable = true, insertable = false)
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATE_BY", updatable = false)
    public Account getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Account createBy) {
        this.createBy = createBy;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATE_BY", insertable = false)
    public Account getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Account updateBy) {
        this.updateBy = updateBy;
    }
}
