package training.patterns.simplefactory.factorymethod;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
            System.out.println("preparing: " + name);
            dough = ingredientFactory.createDough();
            sauce = ingredientFactory.createSauce();
            veggies = ingredientFactory.createVeggies();
            cheese = ingredientFactory.createCheese();
            pepperoni = ingredientFactory.createPepperoni();
            clams = ingredientFactory.createClams();
    }
}
