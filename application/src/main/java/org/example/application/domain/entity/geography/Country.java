package org.example.application.domain.entity.geography;

import org.example.application.domain.entity.base.AuditEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * entity represent country from real world
 */
@Entity
@Table(name = "COUNTRIES")
public final class Country extends AuditEntity {

    private String name;
}
