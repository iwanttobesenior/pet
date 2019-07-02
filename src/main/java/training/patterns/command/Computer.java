package training.patterns.command;

/**
 * {@code class} as receiver
 */
final class Computer {

    void start() {
        System.out.println("start");
    }

    void stop() {
        System.out.println("stop");
    }

    void reset() {
        System.out.println("reset");
    }
}
