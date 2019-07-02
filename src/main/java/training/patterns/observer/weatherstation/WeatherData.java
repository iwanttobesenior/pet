package training.patterns.observer.weatherstation;

import training.patterns.observer.IObserver;
import training.patterns.observer.ISubject;

import java.util.ArrayList;
import java.util.Collection;

class WeatherData implements ISubject {

    private Collection<IObserver> observers;
    private int tmp;
    private int pressure;
    private int humidity;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        /*GUARD CLAUSE*/
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
//        list index of
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        /*GUARD CLAUSE*/
        observers.forEach(o -> o.update(tmp, pressure, humidity));
    }

    public void installData(int tmp, int pressure, int humidity) {
        this.tmp = tmp;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}
