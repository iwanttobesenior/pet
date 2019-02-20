package org.example.application.domain.entity.person;

import org.example.application.domain.entity.base.AuditEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "ACCOUNTS")
@Table
public class Account extends AuditEntity {
}
