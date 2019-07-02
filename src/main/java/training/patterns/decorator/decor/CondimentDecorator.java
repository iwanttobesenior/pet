package training.patterns.decorator.decor;

import training.patterns.decorator.Beverage;

abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public abstract String getDescription();

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
