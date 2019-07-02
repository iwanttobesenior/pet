package training.patterns.command.command;

class LambdaRunner {

    public static void main(String[] args) {

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light();

        Door door = new Door();

        Stereo stereo = new Stereo();

        simpleRemoteControl.setCommands(0, () -> light.on(), () -> light.off());
        simpleRemoteControl.setCommands(1, () -> door.open(), () -> door.close());
        simpleRemoteControl.setCommands(2, () -> {
            stereo.on();
            stereo.setCD();
        }, stereo::off);

        Stereo stereo1 = new Stereo();
        Command stereoOn = () -> {
            stereo1.on();
            stereo1.setCD();
        };

        Command stereoOff = stereo1::off;

        Command noCommand = () -> {};

        simpleRemoteControl.setCommands(3, stereoOn, stereoOff);
    }
}
