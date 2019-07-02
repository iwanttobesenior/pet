package training.patterns.command.command;

class Stereo {

    private int volume;

    public Stereo() {
        this.volume = 11;
    }

    public void on() {
        System.out.println("stereo on");
    }

    public void off(){
        System.out.println("stereo off");
    }

    public void setCD() {
        System.out.println("CD load");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("volume is " + volume);
    }
}
