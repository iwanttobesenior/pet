package org.example.persistence.repository.base;

import org.example.application.infrastructure.exception.uncheked.persistence.PersistenceException;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.example.persistence.configuration.SessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Provide common functionality for all repositories
 *
 * @author Kul'baka Alex
 */
public abstract class BaseHibernateRepository {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());
    private final SessionFactory sessionFactory;

    protected BaseHibernateRepository(final SessionFactoryBuilder sessionFactoryBuilder) {
        this.sessionFactory = sessionFactoryBuilder.getSessionFactory();
    }

    /**
     * Execute update transaction-provided queries
     *
     * @param sessionConsumer
     */
    public void executeWithTransaction(final Consumer<Session> sessionConsumer) {
        Transaction transaction = null;
        try (final Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            sessionConsumer.accept(session);
            transaction.commit();
        } catch (final Exception e) {
            handleError(transaction, e);
            throw new PersistenceException(e);
        }
    }

    /**
     * Execute read queries without transactions and return result
     *
     * @param sessionFunction
     * @return R result
     */
    public <R> R executeWithOutTransaction(final Function<Session, R> sessionFunction) {
        try (final Session session = sessionFactory.openSession()) {
            return sessionFunction.apply(session);
        } catch (final Exception e) {
            handleError(e);
            throw new PersistenceException(e);
        }
    }

    private void handleError(final Transaction transaction, final Exception e) {
        logger.error(e.getMessage(), e);
        handleError(transaction);
    }

    private void handleError(final Exception e) {
        logger.error(e.getMessage(), e);
    }

    private void handleError(final Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
