package training.patterns.mvc;

class BeatControllerImpl implements IBeatController {

    private IBeatModel beatModel;

    public BeatControllerImpl(IBeatModel beatModel) {
        this.beatModel = beatModel;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM() {

    }
}
