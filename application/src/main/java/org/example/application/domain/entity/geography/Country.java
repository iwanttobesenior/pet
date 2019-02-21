package org.example.application.domain.entity.geography;

import org.example.application.domain.entity.base.AuditEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entity represent country from real world
 */
@Entity
@Table(name = "COUNTRIES")
public final class Country extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -4463174449664223721L;

    private String name;
}
