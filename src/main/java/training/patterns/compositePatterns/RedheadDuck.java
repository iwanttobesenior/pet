package training.patterns.compositePatterns;

import training.patterns.compositePatterns.observer.Observable;
import training.patterns.compositePatterns.observer.Observer;

public class RedheadDuck implements Quackable {

    private Observable observable;

    public RedheadDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("redhead quack");
        notifySubscribers();
    }

    @Override
    public void registerSubscriber(Observer observer) {
        observable.registerSubscriber(observer);
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
