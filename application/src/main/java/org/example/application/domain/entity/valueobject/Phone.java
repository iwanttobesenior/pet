package org.example.application.domain.entity.valueobject;

import org.example.application.domain.entity.enums.PhoneType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PHONES")
public final class Phone {

    private String number;
    private PhoneType phoneType;
}
