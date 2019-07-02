package training.patterns.command;

class Runner {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(
                new ComputerStartCommand(computer),
                new ComputerStopCommand(computer),
                new ComputerResetCommand(computer));

        user.starComputer();
        user.stopComputer();
        user.resetComputer();
    }
}
