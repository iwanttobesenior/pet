package training.patterns.facade;

class TheaterLights {

    int bright;

    void dim(int i) {
        bright = i;
    }

    void on() {
        System.out.println("light on " + " bright set to 100");
        bright = 100;
    }
}
