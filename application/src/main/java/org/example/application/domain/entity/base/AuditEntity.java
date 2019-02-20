package org.example.application.domain.entity.base;

import org.example.application.domain.entity.person.Account;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Account getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Account createBy) {
        this.createBy = createBy;
    }

    public Account getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Account updateBy) {
        this.updateBy = updateBy;
    }
}
