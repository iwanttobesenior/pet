package org.example.persistence.repository.person;

import org.example.application.domain.entity.person.User;

import java.util.List;
import java.util.Optional;

/**
 * Repository API for {@link User}
 *
 * @author Kul'baka Alex
 * @see org.example.application.domain.entity.person.User
 */
public interface IUserRepository {

    /**
     * Save new user
     *
     * @param user to save
     */
    void save(final User user);

    /**
     * Find all existing {@link User}'s
     *
     * @return List by users
     */
    List<User> findAll();

    /**
     * Find {@link User} by specific id
     *
     * @param userId
     * @return Optional if specific {@code userId} absent
     */
    Optional<User> findById(final long userId);

    /**
     * Delete specific {@link User} by id
     *
     * @param userId that should be deleted
     */
    void delete(final long userId);

    /**
     * Delete concrete {@link User}
     *
     * @param user obj
     */
    void delete(final User user);

    /**
     * Delete all existing {@link User}
     */
    void deleteAll();

    /**
     * Find {@link User} by specified {@code name}
     *
     * @param userName
     * @return Option by user
     */
    Optional<User> findByUsername(final String userName);
}
