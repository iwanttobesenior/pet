package training.patterns.decorator.decor;

import training.patterns.decorator.Beverage;

class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return + 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " " + "Mocha";
    }
}
