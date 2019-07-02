package training.patterns.compositePatterns.observer;

/**
 * observer
 */
@FunctionalInterface
public interface Observer {

    void update(QuackObservable observable);
}
