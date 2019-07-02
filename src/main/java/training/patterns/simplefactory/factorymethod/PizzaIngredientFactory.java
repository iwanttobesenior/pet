package training.patterns.simplefactory.factorymethod;

import training.patterns.simplefactory.ingridient.*;

public interface PizzaIngredientFactory {

    Dough createDough();

    Cheese createCheese();

    Clams createClams();

    Pepperoni createPepperoni();

    Sauce createSauce();

    Veggies[] createVeggies();
}
