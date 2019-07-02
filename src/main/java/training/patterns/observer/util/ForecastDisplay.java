package training.patterns.observer.util;

import training.patterns.observer.weatherstation.IDisplay;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, IDisplay {

    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ForecastDisplay");
    }

    @Override
    public void display() {

    }
}
