package training.patterns.strategy.behavior.impl;

import training.patterns.strategy.behavior.QuackBehavior;

public class QuackNoWayImpl implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("not quack");
    }
}
