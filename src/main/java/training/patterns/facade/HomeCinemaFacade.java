package training.patterns.facade;

/**
 * Facade
 */
class HomeCinemaFacade {

    final Amplifier amp;
    final Tuner tuner;
    final DvdPlayer dvdPlayer;
    final CdPlayer cdPlayer;
    final Projector projector;
    final TheaterLights lights;
    final Screen screen;
    final PopCornPopper popCornPopper;

    void watchMovie(String movie) {
        System.out.println("get ready to watch movie");

        popCornPopper.on();
        popCornPopper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setDvd(dvdPlayer);
        amp.setSurroundSound();
        amp.setVolume(5);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    void endMovie() {
        System.out.println("shutting movie down");

        popCornPopper.off();

        lights.on();

        screen.up();

        projector.off();

        amp.off();

        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }

    HomeCinemaFacade(Amplifier amp, Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Projector projector, TheaterLights lights, Screen screen, PopCornPopper popCornPopper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popCornPopper = popCornPopper;
    }
}
