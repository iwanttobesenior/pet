package training.patterns.compositePatterns.factory;

import training.patterns.compositePatterns.Quackable;

/**
 * abstract factory
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createRubberDuck();

    public abstract Quackable createDuckCall();
}
