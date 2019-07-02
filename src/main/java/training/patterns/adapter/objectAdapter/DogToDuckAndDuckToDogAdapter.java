package training.patterns.adapter.objectAdapter;

class DogToDuckAndDuckToDogAdapter implements Dog, Duck {

    private final Dog dog;
    private final Duck duck;

    public DogToDuckAndDuckToDogAdapter(Dog dog, Duck duck) {
        this.dog = dog;
        this.duck = duck;
    }

    @Override
    public void bark() {
        duck.quack();
    }

    @Override
    public void run() {
        duck.fly();
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
