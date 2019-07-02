package training.patterns.command.command;

/**
 * command_slot_one
 */
@FunctionalInterface
interface Command {

    void execute();
    default void undo(){}
}
