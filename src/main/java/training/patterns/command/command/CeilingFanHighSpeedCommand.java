package training.patterns.command.command;

class CeilingFanHighSpeedCommand implements Command {

    private final CeilingFan ceilingFan;

    private int previusSpeed;

    public CeilingFanHighSpeedCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previusSpeed = ceilingFan.getSpeed();
        ceilingFan.setHighSpeed();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previusSpeed);
    }
}
