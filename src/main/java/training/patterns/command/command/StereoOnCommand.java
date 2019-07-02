package training.patterns.command.command;

class StereoOnCommand implements Command {

    private final Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
