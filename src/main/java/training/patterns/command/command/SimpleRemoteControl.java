package training.patterns.command.command;

/**
 * Invoker or initiator
 */
class SimpleRemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command undo;

    private static final int MAX_COMMAND_SIZE = 7;

    public SimpleRemoteControl() {
        this.onCommands = new Command[MAX_COMMAND_SIZE];
        this.offCommands = new Command[MAX_COMMAND_SIZE];

        Command noCommand = new NoCommand();

        for (int i = 0; i < MAX_COMMAND_SIZE; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        this.undo = noCommand;
    }

    public void setCommands(int slotForCommand, Command onCommand, Command offCommand) {
        onCommands[slotForCommand] = onCommand;
        offCommands[slotForCommand] = offCommand;
    }

    public void setOnlyOnCommand(int slotForCommand, Command onCommand) {
        onCommands[slotForCommand] = onCommand;
    }

    public void setOnlyOffCommand(int slotForCommand, Command offCommand) {
        offCommands[slotForCommand] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undo = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undo = offCommands[slot];
    }

    public void undoButtonWasPressed(){
        undo.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Remote control :");

        for (int i = 0; i < MAX_COMMAND_SIZE; i++) {
            stringBuilder.append("slot ").append(i).append(" onCommand: ").append(onCommands[i]
                    .getClass()
                    .getSimpleName()).append(" , ").append(" offCommand: ").append(offCommands[i]
                    .getClass()
                    .getSimpleName()).append(" . ");
        }

        return stringBuilder.toString();
    }
}
