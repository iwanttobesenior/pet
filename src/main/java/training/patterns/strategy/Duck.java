package training.patterns.strategy;

import training.patterns.strategy.behavior.FlyBehavior;
import training.patterns.strategy.behavior.QuackBehavior;
import training.patterns.strategy.behavior.impl.QuackNoWayImpl;

abstract class Duck {

    public Duck() {
        this.quackBehavior = new QuackNoWayImpl();
    }

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }

    abstract void display();

    void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
