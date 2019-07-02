package training.patterns.compositePatterns.composite;

import training.patterns.compositePatterns.Quackable;
import training.patterns.compositePatterns.observer.Observable;
import training.patterns.compositePatterns.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * composite
 * and
 * iterator
 */
public class Flock implements Quackable {

    private List<Quackable> quackables;

    private Observable observable;

    public Flock() {
        this.quackables = new ArrayList<>();
    }

    public void addQuackers(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quackable : quackables) {
            quackable.quack();
        }
    }

    @Override
    public void registerSubscriber(Observer observer) {
        for (Quackable quackable : quackables) {
            quackable.registerSubscriber(observer);
        }
    }

    @Override
    public void notifySubscribers() {
        observable.notifySubscribers();
    }

    @Override
    public void removeSubscriber(Observer observer) {
        for (Quackable quackable : quackables) {
            quackable.removeSubscriber(observer);
        }
    }
}
