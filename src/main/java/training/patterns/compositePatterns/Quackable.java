package training.patterns.compositePatterns;

import training.patterns.compositePatterns.observer.QuackObservable;

public interface Quackable extends QuackObservable {

    void quack();
}
