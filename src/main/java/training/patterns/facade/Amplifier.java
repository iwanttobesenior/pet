package training.patterns.facade;

class Amplifier {

    int volume;

    public Amplifier() {
        this.volume = 10;
    }

    void on() {
        System.out.println("amplifier on");
    }

    void setDvd(DvdPlayer dvdPlayer) {
        System.out.println("load dvd " + dvdPlayer);
    }

    void setSurroundSound() {
        System.out.println("surround mode on");
    }

    void setVolume(int i) {
        System.out.println("volume set to " + i);
        volume = i;
    }

    void off() {
        System.out.println("amplifier off");
    }
}
