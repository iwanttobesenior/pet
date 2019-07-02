package training.patterns.observer.util;

import training.patterns.observer.weatherstation.IDisplay;

import java.util.Observable;
import java.util.Observer;

public class StatisticDisplay implements Observer, IDisplay {

    private Observable observable;

    public StatisticDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("StatisticDisplay " + arg);
        if (o.hasChanged()) {
            System.out.println("true");
        }
        System.out.println("false");
    }

    @Override
    public void display() {

    }
}
