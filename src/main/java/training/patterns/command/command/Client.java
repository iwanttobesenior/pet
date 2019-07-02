package training.patterns.command.command;

/**
 * client
 */
class Client {

    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light();
        Command lightOn = new LightOnCommand(light);

        Door door = new Door();
        Command doorOpen = new DoorOpenCommand(door);

        Car car = new Car();
        Command carEngine = new CarEngineOnCommand(car);
    }
}
