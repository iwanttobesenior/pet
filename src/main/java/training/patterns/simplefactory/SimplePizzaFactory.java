package training.patterns.simplefactory;

public class SimplePizzaFactory {

    Pizza createPizza(Pizza.PizzaType pizzaType) {
        Pizza pizza = null;
        if (Pizza.PizzaType.CHEESE == pizzaType) {
            pizza = new Cheese();
        } else if (Pizza.PizzaType.CLAM == pizzaType) {
            pizza = new Clam();
        } else if (Pizza.PizzaType.MEAT == pizzaType) {
            pizza = new Meat();
        } else if (Pizza.PizzaType.PEPPERONI == pizzaType) {
            pizza = new Pepperoni();
        } else if (Pizza.PizzaType.VEGGIE == pizzaType) {
            pizza = new Veggie();
        }
        return pizza;
    }

    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("CHEESE".equals(type)) {
            pizza = new Cheese();
        } else if ("CLAM".equals(type)) {
            pizza = new Clam();
        } else if ("MEAT".equals(type)) {
            pizza = new Meat();
        } else if ("PEPPERONI".equals(type)) {
            pizza = new Pepperoni();
        } else if ("VEGGIE".equals(type)) {
            pizza = new Veggie();
        }
        return pizza;
    }
}
