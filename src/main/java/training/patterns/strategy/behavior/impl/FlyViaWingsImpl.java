package training.patterns.strategy.behavior.impl;

import training.patterns.strategy.behavior.FlyBehavior;

public class FlyViaWingsImpl implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly() wings");
    }
}
