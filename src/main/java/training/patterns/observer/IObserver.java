package training.patterns.observer;

public interface IObserver {

    default void update(int tmp, int pressure, int humidity) {
        System.out.println("update done.");
    }
}
