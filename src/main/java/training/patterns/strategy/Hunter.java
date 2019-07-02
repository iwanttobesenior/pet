package training.patterns.strategy;

import training.patterns.strategy.behavior.QuackBehavior;
import training.patterns.strategy.behavior.impl.QuackNoWayImpl;

public final class Hunter {

    private QuackBehavior quackBehavior;

    public Hunter() {
        this.quackBehavior = new QuackNoWayImpl();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void bait() {
        quackBehavior.quack();
    }
}
