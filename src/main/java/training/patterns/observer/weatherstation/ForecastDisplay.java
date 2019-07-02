package training.patterns.observer.weatherstation;

import training.patterns.observer.IObserver;
import training.patterns.observer.ISubject;

public class ForecastDisplay implements IObserver, IDisplay {

    private ISubject subject;

    private int tmp;
    private int pressure;
    private int humidity;

    public ForecastDisplay(ISubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int tmp, int pressure, int humidity) {
        this.tmp = tmp;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay  " + tmp + "  " + pressure + "  " + humidity);
    }
}
