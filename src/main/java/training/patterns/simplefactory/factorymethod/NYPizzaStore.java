package training.patterns.simplefactory.factorymethod;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if (pizzaType.equals("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("NY style cheese pizza");
        }

        if (pizza.equals("clam")) {

            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("NY style clam pizza");
        }

        return pizza;
    }
}
