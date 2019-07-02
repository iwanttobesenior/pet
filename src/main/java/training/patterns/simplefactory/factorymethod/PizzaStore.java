package training.patterns.simplefactory.factorymethod;

public abstract class PizzaStore {

    final Pizza orderPizza(String pizzaType) {
        Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * factory method
     */
    abstract training.patterns.simplefactory.factorymethod.Pizza createPizza(String pizzaType);
}
