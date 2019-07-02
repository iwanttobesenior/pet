package training.patterns.facade;

class DvdPlayer {

    void on() {
        System.out.println("Dvd on");
    }

    void play(String movie) {
        System.out.println("movie " + movie + " begin");
    }

    void stop() {
        System.out.println("Dvd stop");
    }

    void eject() {
        System.out.println("Cd ejected");
    }

    void off() {
        System.out.println("Dvd off");
    }
}
