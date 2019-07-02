package training.patterns.command.command;

class CeilingFanLowSpeedCommand implements Command {

    private final CeilingFan ceilingFan;

    private int previusSpeed;

    public CeilingFanLowSpeedCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previusSpeed = ceilingFan.getSpeed();
        ceilingFan.setLowSpeed();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previusSpeed);
    }
}
