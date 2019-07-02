package training.patterns.command.command;

class CarEngineOnCommand implements Command {

    private final Car car;

    public CarEngineOnCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.engine();
    }

    @Override
    public void undo() {

    }
}
