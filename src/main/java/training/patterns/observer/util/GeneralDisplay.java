package training.patterns.observer.util;

import training.patterns.observer.weatherstation.IDisplay;

import java.util.Observable;
import java.util.Observer;

public class GeneralDisplay implements Observer, IDisplay {

    private Observable observable;

    public GeneralDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("GeneralDisplay");
    }

    @Override
    public void display() {

    }
}
