package training.patterns.compositePatterns.adapter;

import training.patterns.compositePatterns.Goose;
import training.patterns.compositePatterns.Quackable;
import training.patterns.compositePatterns.observer.Observer;

/**
 * adapter
 */
public class GooseToDuckAdapter implements Quackable {

    private final Goose goose;

    public GooseToDuckAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerSubscriber(Observer observer) {
//        NOP
    }

    @Override
    public void notifySubscribers() {
//        NOP
    }

    @Override
    public void removeSubscriber(Observer observer) {
//        NOP
    }
}
