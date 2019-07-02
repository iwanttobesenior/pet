package training.patterns.singleton;

/**
 * classic singleton
 * lazy initialization
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
        /*NOP*/
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
