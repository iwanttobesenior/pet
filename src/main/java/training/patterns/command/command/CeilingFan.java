package training.patterns.command.command;

class CeilingFan {

    private static final int HIGH_SPEED = 3;
    private static final int MEDIUM_SPEED = 2;
    private static final int LOW_SPEED = 1;
    private static final int OFF = 0;

    private final String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void setHighSpeed() {
        System.out.println("speed was set to high");
        speed = HIGH_SPEED;
    }

    public void setMediumSpeed() {
        System.out.println("speed was set to medium");
        speed = MEDIUM_SPEED;
    }

    public void setLowSpeed() {
        System.out.println("speed was set to low");
        speed = LOW_SPEED;
    }

    public int getSpeed() {
        return speed;
    }

    public void off() {
        System.out.println("off");
        speed = OFF;
    }

    public void setSpeed(int speed) {
        if (speed == OFF) {
            off();
        } else if (speed == LOW_SPEED) {
            setLowSpeed();
        } else if (speed == MEDIUM_SPEED) {
            setMediumSpeed();
        } else if (speed == HIGH_SPEED) {
            setHighSpeed();
        }
    }
}
