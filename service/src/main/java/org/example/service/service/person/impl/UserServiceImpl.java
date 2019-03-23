package org.example.service.service.person.impl;

import org.example.application.domain.entity.person.User;
import org.example.application.infrastructure.util.security.SecurityUtil;
import org.example.persistence.repository.person.IUserRepository;
import org.example.service.service.person.IUserService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link IUserService}
 *
 * @author Kul'baka Alex
 * @see User
 */
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Inject
    public UserServiceImpl(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(final User user) {
        final String password = user.getPassword();
        final String encryptedPassword = SecurityUtil.encryptSHA(password);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(final int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(final int userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(final String userName) {
        return userRepository.findByUsername(userName);
    }
}
