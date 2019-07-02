package training.patterns.command.command;

class CeilingFanMediumSpeedCommand implements Command {

    private final CeilingFan ceilingFan;

    private int previusSpeed;

    public CeilingFanMediumSpeedCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previusSpeed = ceilingFan.getSpeed();
        ceilingFan.setMediumSpeed();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previusSpeed);
    }
}
