package training.patterns.adapter.objectAdapter;

/**
 * Client
 */
class Runner {

    public static void main(String[] args) {

        Duck duck = new MallardDuck();

        Dog dog = new NiceDog("Mails");
        Duck adapter = new DuckToDogAdapter(dog);

        letDuckQuack(duck);
        letDuckQuack(adapter);

        Dog adapter1 = new DogToDuckAdapter(duck);
        letDogBark(adapter1);

    }

    static void letDuckQuack(Duck duck) {
        duck.quack();
    }

    static void letDogBark(Dog dog) {
        dog.bark();
    }
}
