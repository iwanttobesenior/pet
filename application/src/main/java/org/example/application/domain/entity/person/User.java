package org.example.application.domain.entity.person;

import org.example.application.domain.entity.base.AuditEntity;
import org.example.application.domain.entity.valueobject.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author Kul'baka Alex
 */
@Entity
@Table(name = "USERS")
@NamedQueries
        ({
                @NamedQuery(name = "User.FIND_ALL_QUERY", query = "from User"),
                @NamedQuery(name = "User.DELETE_ALL_QUERY", query = "delete from User")

        })
public class User extends AuditEntity implements Serializable {

    public static final String FIND_ALL_QUERY = "";
    public static final String DELETE_ALL_QUERY = "";

    private static final long serialVersionUID = -4116198885518644286L;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Phone> phone;

    public User() {
    }

    public User(String email) {
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

    @NotNull
    @Size(min = 4, max = 120)
    @Column(name = "PASSWORD", length = 120, nullable = false)
    public String getPassword() {
        return password;
    }

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    public List<Phone> getPhone() {
        return phone;
    }

    @NotNull
    @Size(min = 2, max = 32)
    @Column(name = "USERNAME", length = 32, unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    private void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    private void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    private void setPhone(final List<Phone> phone) {
        this.phone = phone;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
