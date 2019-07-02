package training.patterns.simplefactory;

public interface Pizza {

    void prepare();

    void bake();

    void cut();

    void box();

    enum PizzaType {
        CHEESE, PEPPERONI, CLAM, VEGGIE, MEAT
    }
}
