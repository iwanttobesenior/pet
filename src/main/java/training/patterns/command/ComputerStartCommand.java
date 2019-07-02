package training.patterns.command;

class ComputerStartCommand implements Command {

    private final Computer computer;

    public ComputerStartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}
