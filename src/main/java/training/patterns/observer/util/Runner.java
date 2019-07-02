package training.patterns.observer.util;

import java.util.Observable;
import java.util.Observer;

public class Runner {

    public static void main(String[] args) {
        Observable subject = new WeatherData();

        Observer observer1 = new ForecastDisplay(subject);
        Observer observer2 = new StatisticDisplay(subject);

        ((WeatherData) subject).installData(999);
    }
}
