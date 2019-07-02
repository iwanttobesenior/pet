package training.patterns.templatemethod;

abstract class CaffeineBeverage {

    /**
     * template method
     */
    final void prepare() {
        boilWater();
        brew();
        if (hook()) {
            addCondiments();
        }
        pourInCup();
    }

    abstract void brew();

    abstract void addCondiments();

    /**
     * hook method in template method pattern
     */
    boolean hook() {
        return true;
    }

    final void pourInCup() {
        System.out.println("pouring into cap");
    }

    final void boilWater() {
        System.out.println("water boil to 100 degrees");
    }
}
