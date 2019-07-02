package training.patterns.command.command;

class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("NOP");
    }

    @Override
    public void undo() {
        System.out.println("NOP");
    }
}
