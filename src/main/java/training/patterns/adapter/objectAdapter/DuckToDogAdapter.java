package training.patterns.adapter.objectAdapter;

/**
 * Adapter
 */
class DuckToDogAdapter implements Duck {

    private final Dog dog;

    DuckToDogAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void quack() {
        dog.bark();
    }

    @Override
    public void fly() {
        dog.run();
    }
}
