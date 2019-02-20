package org.example.application.domain.entity.valueobject;

import javax.persistence.Embeddable;

@Embeddable
public final class Address {

    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private int zipCode;
}
