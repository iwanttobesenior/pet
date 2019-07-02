package training.patterns.command.command;

class Runner {

    public static void main(String[] args) {

        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        Door door = new Door();
        Command doorOpenCommand = new DoorOpenCommand(door);
        Command doorCloseCommand = new DoorCloseCommand(door);

        Car car = new Car();
        Command carEngineOnCommand = new CarEngineOnCommand(car);

        Stereo stereo = new Stereo();
        Command stereoOnCommand = new StereoOnCommand(stereo);
        Command stereoOffCommand = new StereoOffCommand(stereo);

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        simpleRemoteControl.setCommands(0, doorOpenCommand, doorCloseCommand);
        simpleRemoteControl.setCommands(2, lightOnCommand, lightOffCommand);
        simpleRemoteControl.setOnlyOnCommand(4, carEngineOnCommand);
        simpleRemoteControl.setCommands(6, stereoOnCommand, stereoOffCommand);

        simpleRemoteControl.onButtonWasPressed(0);
        simpleRemoteControl.offButtonWasPressed(0);
        simpleRemoteControl.onButtonWasPressed(1);
        simpleRemoteControl.offButtonWasPressed(1);
        simpleRemoteControl.onButtonWasPressed(2);
        simpleRemoteControl.offButtonWasPressed(2);
        simpleRemoteControl.onButtonWasPressed(3);
        simpleRemoteControl.offButtonWasPressed(3);
        simpleRemoteControl.onButtonWasPressed(4);
        simpleRemoteControl.offButtonWasPressed(4);
        simpleRemoteControl.onButtonWasPressed(5);
        simpleRemoteControl.offButtonWasPressed(5);
        simpleRemoteControl.onButtonWasPressed(6);
        simpleRemoteControl.offButtonWasPressed(6);

        simpleRemoteControl.setCommands(0, lightOnCommand, lightOffCommand);
        simpleRemoteControl.onButtonWasPressed(0);
        simpleRemoteControl.undoButtonWasPressed();

        simpleRemoteControl.onButtonWasPressed(0);
        simpleRemoteControl.offButtonWasPressed(0);
        simpleRemoteControl.undoButtonWasPressed();

        CeilingFan ceilingFan = new CeilingFan("LivingRoom");
        Command ceilingFanHighSpeedCommand = new CeilingFanHighSpeedCommand(ceilingFan);
        Command ceilingFanLowSpeedCommand = new CeilingFanLowSpeedCommand(ceilingFan);
        Command ceilingFanMediumSpeedCommand = new CeilingFanMediumSpeedCommand(ceilingFan);
        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        simpleRemoteControl.setCommands(1, ceilingFanLowSpeedCommand, ceilingFanOffCommand);
        simpleRemoteControl.setCommands(2, ceilingFanMediumSpeedCommand, ceilingFanOffCommand);
        simpleRemoteControl.setCommands(3, ceilingFanHighSpeedCommand, ceilingFanOffCommand);

        simpleRemoteControl.onButtonWasPressed(1);
        simpleRemoteControl.offButtonWasPressed(1);
        simpleRemoteControl.undoButtonWasPressed();

        System.out.println(simpleRemoteControl);
    }
}
