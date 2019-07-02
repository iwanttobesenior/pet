package training.patterns.command.command;

class MacroRunner {

    public static void main(String[] args) {

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        Door door = new Door();
        DoorOpenCommand doorOpenCommand = new DoorOpenCommand(door);
        DoorCloseCommand doorCloseCommand = new DoorCloseCommand(door);

        CeilingFan ceilingFan = new CeilingFan("garage");
        CeilingFanHighSpeedCommand ceilingFanHighSpeedCommand = new CeilingFanHighSpeedCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        Car car = new Car();
        CarEngineOnCommand carEngineOnCommand = new CarEngineOnCommand(car);


        Command[] partyOnCommands = new Command[]{lightOnCommand, doorOpenCommand, ceilingFanHighSpeedCommand, carEngineOnCommand};
        Command[] partyOffCommands = new Command[]{lightOffCommand, doorCloseCommand, ceilingFanOffCommand};

        Command macroOnCommands = new MacroCommand(partyOnCommands);
        Command macroOffCommands = new MacroCommand(partyOffCommands);

        macroOnCommands.execute();
        macroOffCommands.execute();
        macroOffCommands.undo();


    }
}
