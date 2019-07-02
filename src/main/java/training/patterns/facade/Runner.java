package training.patterns.facade;

public class Runner {

    public static void main(String[] args) {

        Amplifier amplifier = new Amplifier();
        CdPlayer cdPlayer = new CdPlayer();
        DvdPlayer dvdPlayer = new DvdPlayer();
        PopCornPopper popCornPopper = new PopCornPopper();
        Projector projector = new Projector();
        Screen screen = new Screen();
        Tuner tuner = new Tuner();
        TheaterLights theaterLights = new TheaterLights();

        HomeCinemaFacade facade = new HomeCinemaFacade(amplifier, tuner, dvdPlayer, cdPlayer, projector, theaterLights, screen, popCornPopper);

        facade.watchMovie("Dark City");

        facade.endMovie();
    }
}
