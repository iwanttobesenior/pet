package training.patterns.compositePatterns.factory;

import training.patterns.compositePatterns.*;
import training.patterns.compositePatterns.decorator.QuackCounterDecorator;

/**
 * {@link Quackable} instance with decorator
 */
public class CountingDecoratorAbstractDuckFactoryImpl extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounterDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounterDecorator(new RedheadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounterDecorator(new RubberDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounterDecorator(new DuckCall());
    }
}
