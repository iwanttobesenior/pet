package training.patterns.observer.util;

import java.util.Observable;

public class WeatherData extends Observable {

    private int tmp;
    private int pressure;
    private int humidity;

    public void installData(int tmp) {
        this.tmp = tmp;
        setChanged();
        notifyObservers(tmp);
    }

    public int getTmp() {
        return tmp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
