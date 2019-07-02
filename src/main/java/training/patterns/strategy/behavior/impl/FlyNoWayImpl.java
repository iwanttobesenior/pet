package training.patterns.strategy.behavior.impl;

import training.patterns.strategy.behavior.FlyBehavior;

public class FlyNoWayImpl implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("not fly");
    }
}
