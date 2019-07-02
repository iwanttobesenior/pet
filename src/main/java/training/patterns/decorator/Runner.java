package training.patterns.decorator;

import training.patterns.decorator.decor.Milk;
import training.patterns.decorator.decor.Soy;
import training.patterns.decorator.decor.Whip;

abstract class Runner {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("beverage = " + beverage.getDescription() + " $ " + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Milk(beverage1);
        beverage1 = new Milk(beverage1);
        beverage1 = new Soy(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println("beverage1 = " + beverage1.getDescription() + " $ " + beverage1.cost());
    }
}
