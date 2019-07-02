package training.patterns.decorator.decor;

import training.patterns.decorator.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.45 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " " + "Whip";
    }
}
