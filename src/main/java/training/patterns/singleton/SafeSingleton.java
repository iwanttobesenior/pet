package training.patterns.singleton;

public class SafeSingleton {

    private static SafeSingleton instance = new SafeSingleton();

    private SafeSingleton() {
        /*NOP*/
    }

    public static SafeSingleton getInstance() {
        return instance;
    }
}
