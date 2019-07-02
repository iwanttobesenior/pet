package training.patterns.singleton;

public class SingletonSynch {

    private volatile static SingletonSynch instance;

    private SingletonSynch() {
        /*NOP*/
    }

    public static SingletonSynch getInstance() {
        if (instance == null) {
            synchronized (SingletonSynch.class) {
                if (instance == null) {
                    instance = new SingletonSynch();
                }
            }
        }

        return instance;
    }
}
