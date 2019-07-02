package training.patterns.observer.weatherstation;

import training.patterns.observer.IObserver;
import training.patterns.observer.ISubject;

public class Runner {

    public static void main(String[] args) {
        ISubject subject = new WeatherData();
        ((WeatherData) subject).installData(22, 11, 444);

        IObserver observer1 = new CurrentConditionsDisplay(subject);
        IObserver observer2 = new ForecastDisplay(subject);
        IObserver observer3 = new StatisticDisplay(subject);

        subject.notifyObserver();

        ((WeatherData) subject).installData(0, 0, 0);

        subject.notifyObserver();
    }
}

