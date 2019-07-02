package training.patterns.strategy.behavior.impl;

import training.patterns.strategy.behavior.QuackBehavior;

public class QuackTypicalImpl implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quack() typical");
    }
}
