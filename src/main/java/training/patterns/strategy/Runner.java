package training.patterns.strategy;

import training.patterns.strategy.behavior.impl.FlyNoWayImpl;
import training.patterns.strategy.behavior.impl.FlyViaRocketEngineImpl;
import training.patterns.strategy.behavior.impl.QuackFakeImpl;
import training.patterns.strategy.behavior.impl.QuackTypicalImpl;

public class Runner {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyNoWayImpl());
        duck.setQuackBehavior(new QuackFakeImpl());

        duck.performFly();
        duck.performQuack();

        duck.setFlyBehavior(new FlyViaRocketEngineImpl());
        duck.setQuackBehavior(new QuackTypicalImpl());

        duck.performFly();
        duck.performQuack();

        System.out.println("***************");

        Hunter hunter = new Hunter();
        hunter.bait();
        hunter.setQuackBehavior(new QuackFakeImpl());
        hunter.bait();

        System.out.println("***************");

        Duck modelDuck = new ModelDuck();
        modelDuck.performQuack();
        modelDuck.performFly();

        modelDuck.setQuackBehavior(new QuackTypicalImpl());

        modelDuck.performQuack();

        System.out.println("***************");

        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();

    }
}
