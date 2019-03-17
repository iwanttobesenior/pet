package org.example.service.service.person;

import org.example.application.domain.entity.person.User;

import java.util.List;
import java.util.Optional;

/**
 * Service for {@link org.example.application.domain.entity.person.User}
 *
 * @author Kul'baka Alex
 */
public interface IUserService {

    void save(final User user);

    Optional<User> findById(final int userId);

    void delete(final int userId);

    List<User> findAll();

    /**
     * Returns {@link User} with specified {@code userName}
     *
     * @param userName
     * @return Optinal by user
     */
    Optional<User> findByUsername(final String userName);
}
