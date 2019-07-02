package training.patterns.compositePatterns.observer;

/**
 * observable
 */
public interface QuackObservable {

    void registerSubscriber(Observer observer);

    void notifySubscribers();

    void removeSubscriber(Observer observer);
}
