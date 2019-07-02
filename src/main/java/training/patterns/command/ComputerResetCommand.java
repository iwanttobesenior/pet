package training.patterns.command;

/**
 * Concrete Command
 */
class ComputerResetCommand implements Command {

    private final Computer computer;

    public ComputerResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}
