package training.patterns.compositePatterns;

import training.patterns.compositePatterns.composite.Flock;
import training.patterns.compositePatterns.factory.AbstractDuckFactory;
import training.patterns.compositePatterns.factory.CountingDecoratorAbstractDuckFactoryImpl;

class Runner {

    public static void main(String[] args) {
        new Runner().simulate(new CountingDecoratorAbstractDuckFactoryImpl());
    }

    void simulate(AbstractDuckFactory duckFactory) {

        Quackable quackable_decorator1 = duckFactory.createDuckCall();
        Quackable quackable_decorator2 = duckFactory.createRedheadDuck();
        Quackable quackable_decorator3 = duckFactory.createRedheadDuck();
        Quackable quackable_decorator4 = duckFactory.createRubberDuck();
        Quackable quackable_decorator5 = duckFactory.createRubberDuck();
        Quackable quackable_decorator6 = duckFactory.createRubberDuck();
        Quackable quackable_decorator7 = duckFactory.createRubberDuck();

        Flock flock = new Flock();
        flock.addQuackers(quackable_decorator1);
        flock.addQuackers(quackable_decorator2);
        flock.addQuackers(quackable_decorator3);
        flock.addQuackers(quackable_decorator4);
        flock.addQuackers(quackable_decorator5);
        flock.addQuackers(quackable_decorator6);
        flock.addQuackers(quackable_decorator7);

        Flock mallardDuckFlock = new Flock();
        mallardDuckFlock.addQuackers(duckFactory.createMallardDuck());
        mallardDuckFlock.addQuackers(duckFactory.createMallardDuck());
        mallardDuckFlock.addQuackers(duckFactory.createMallardDuck());
        mallardDuckFlock.addQuackers(duckFactory.createMallardDuck());

        Quackable duckCall1 = duckFactory.createDuckCall();
        Quackable duckCall2 = duckFactory.createDuckCall();

        duckCall1.registerSubscriber(System.out::println);

//        flock.addQuackers(mallardDuckFlock);

//        simulate(flock);

        System.out.println();

//        simulate(mallardDuckFlock);
    }

    void simulate(Quackable quackable) {
        quackable.quack();
    }
}
