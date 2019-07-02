package training.patterns.compositePatterns.decorator;

import training.patterns.compositePatterns.Quackable;
import training.patterns.compositePatterns.observer.Observable;
import training.patterns.compositePatterns.observer.Observer;

/**
 * decorator
 */
public class QuackCounterDecorator implements Quackable {

    private final Quackable quackable;
    static int numberOfQuack;

    private Observable observable;

    public QuackCounterDecorator(Quackable quackable) {
        this.quackable = quackable;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        quackable.quack();
        numberOfQuack++;
    }

    public static int getNumberOfQuack() {
        return numberOfQuack;
    }

    @Override
    public void registerSubscriber(Observer observer) {
        observable.removeSubscriber(observer);
    }

    @Override
    public void notifySubscribers() {
        observable.notifySubscribers();
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observable.removeSubscriber(observer);
    }
}
