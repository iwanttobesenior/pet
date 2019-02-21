package org.example.application.domain.entity.valueobject;

import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.enums.PhoneType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PHONES")
public final class Phone extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -6892594993554726249L;

    private String number;
    
    private PhoneType phoneType;

    @Column(name = "NUMBER", nullable = false, length = 50)
    public String getNumber() {
        return number;
    }

    @Enumerated(EnumType.STRING)
    public PhoneType getPhoneType() {
        return phoneType;
    }
}
