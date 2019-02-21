package org.example.application.domain.entity.person;

import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.valueobject.Phone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "ACCOUNTS")
@Table
public class Account extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -4116198885518644286L;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Phone> phone;

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

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    public List<Phone> getPhone() {
        return phone;
    }
}
