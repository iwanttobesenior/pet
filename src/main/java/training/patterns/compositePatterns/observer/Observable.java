package training.patterns.compositePatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * observable helper class that encapsulate {@link QuackObservable} behavior
 */
public class Observable implements QuackObservable {

    private List<Observer> observerList;
    private QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerSubscriber(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifySubscribers() {
        for (Observer observer : observerList) {
            observer.update(duck);
        }
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observerList.remove(observer);
    }
}
