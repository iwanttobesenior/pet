package training.patterns.strategy;

import training.patterns.strategy.behavior.impl.FlyNoWayImpl;
import training.patterns.strategy.behavior.impl.QuackNoWayImpl;

public class ModelDuck extends Duck {

    public ModelDuck() {
        setFlyBehavior(new FlyNoWayImpl());
        setQuackBehavior(new QuackNoWayImpl());
    }

    @Override
    void display() {
        System.out.println("display() BeatModel");
    }
}
