package org.example.persistence.repository.person.impl.hibernate;

import org.example.application.domain.entity.person.User;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.example.persistence.repository.base.BaseHibernateRepository;
import org.example.persistence.repository.person.IUserRepository;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link IUserRepository}
 *
 * @author Kul'baka Alex
 * @see BaseHibernateRepository
 */
@Named
public class HibernateUserRepository extends BaseHibernateRepository implements IUserRepository {

    @Inject
    protected HibernateUserRepository(final SessionFactoryBuilder sessionFactoryBuilder) {
        super(sessionFactoryBuilder);
    }

    @Override
    public void save(final User user) {
        executeWithTransaction(session -> session.saveOrUpdate(user));
    }

    @Override
    public List<User> findAll() {
        return executeWithOutTransaction(session -> session.createNamedQuery(User.FIND_ALL_QUERY, User.class)
                .list());
    }

    @Override
    public Optional<User> findById(final long userId) {
        return executeWithOutTransaction(session -> Optional.ofNullable(session.get(User.class, userId)));
    }

    @Override
    public void delete(long userId) {
        executeWithTransaction(session -> {
            final User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
            }
        });
    }

    @Override
    public void delete(final User user) {
        executeWithTransaction(session -> session.delete(user));
    }

    @Override
    public void deleteAll() {
        executeWithTransaction(session -> session.createNamedQuery(User.DELETE_ALL_QUERY).executeUpdate());
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return executeWithOutTransaction(session -> {
            Query query = session.createQuery("from User as u where u.username=:userName");
            query.setParameter("userName", userName);
            return query.uniqueResultOptional();
        });
    }
}
