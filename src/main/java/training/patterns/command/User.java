package training.patterns.command;

/**
 * {@code class} as Invoker
 */
class User {

    private final Command startCommand;
    private final Command stopCommand;
    private final Command resetCommand;

    public User(Command startCommand, Command stopCommand, Command resetCommand) {
        this.startCommand = startCommand;
        this.stopCommand = stopCommand;
        this.resetCommand = resetCommand;
    }

    public void starComputer() {
        startCommand.execute();
    }

    public void stopComputer() {
        stopCommand.execute();
    }

    public void resetComputer() {
        resetCommand.execute();
    }
}
