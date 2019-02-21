package org.example.application.domain.entity.person;

import org.example.application.domain.entity.base.AuditEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "ACCOUNTS")
@Table
public class Account extends AuditEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public Account() {
    }

    public Account(String email) {
        this.email = email;
    }

    @Column(name = "FIRST_NAME", length = 32)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LAST_NAME", length = 32)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "EMAIL", length = 64)
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD", length = 32)
    public String getPassword() {
        return password;
    }
}
