package training.patterns.simplefactory.factorymethod;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        if (pizzaType.equals("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago style cheese pizza");
        }

        if (pizzaType.equals("clam")) {
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago style clam pizza");
        }

        return pizza;
    }
}
