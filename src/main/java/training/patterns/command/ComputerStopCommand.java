package training.patterns.command;

class ComputerStopCommand implements Command{

    private final Computer computer;

    public ComputerStopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
