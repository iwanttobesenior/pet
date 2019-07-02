package training.patterns.adapter.objectAdapter;

class DogToDuckAdapter implements Dog {

    private final Duck duck;

    public DogToDuckAdapter(Duck duck) {
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
}
