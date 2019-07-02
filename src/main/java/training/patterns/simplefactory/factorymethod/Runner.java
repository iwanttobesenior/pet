package training.patterns.simplefactory.factorymethod;

public class Runner {

    public static void main(String[] args) {
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza chicagoCheese = chicagoPizzaStore.orderPizza("cheese");
        Pizza nyCheese = nyPizzaStore.orderPizza("cheese");

        System.out.println(chicagoCheese.getName());
        System.out.println(nyCheese.getName());
    }
}
