package training.patterns.simplefactory.factorymethod;

public class ChicagoStyleCheesePizza extends Pizza {

    @Override
    void prepare() {

    }

    @Override
    public void cut() {
        System.out.println("cutting into square slices");
    }
}
