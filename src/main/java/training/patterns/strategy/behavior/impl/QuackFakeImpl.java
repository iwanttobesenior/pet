package training.patterns.strategy.behavior.impl;

import training.patterns.strategy.behavior.QuackBehavior;

public class QuackFakeImpl implements QuackBehavior {

    private String whistleMaker;

    @Override
    public void quack() {
        System.out.println("quack() whistle");
    }
}
