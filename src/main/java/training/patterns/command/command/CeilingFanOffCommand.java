package training.patterns.command.command;

class CeilingFanOffCommand implements Command {

    private final CeilingFan ceilingFan;

    private int previusSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previusSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previusSpeed);
    }
}
