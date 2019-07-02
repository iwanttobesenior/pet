package training.patterns.command.command;

/**
 * receiver
 */
class Light {

    void on() {
        System.out.println("light is on");
    }

    void off() {
        System.out.println("light is off");
    }
}
