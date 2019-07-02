package training.patterns.decorator.decor;

import training.patterns.decorator.Beverage;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.25 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " " + "milk";
    }
}
