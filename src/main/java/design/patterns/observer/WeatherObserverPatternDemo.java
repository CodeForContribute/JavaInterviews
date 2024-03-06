package design.patterns.observer;

public class WeatherObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStationObservable weatherStationObservable = new WeatherStationObservableImpl();
        DisplayObserver tvDisplayObserver = new TVDisplayObserver(weatherStationObservable);
        weatherStationObservable.addObserver(tvDisplayObserver);
        DisplayObserver mobileDisplayObserver = new MobileDisplayObserver(weatherStationObservable);
        weatherStationObservable.addObserver(mobileDisplayObserver);
        int temperature = 34;
        System.out.println("Changing temperature to >>>>>>>>>>>>." + temperature);
        weatherStationObservable.setTemperature(temperature);
        temperature = 56;
        System.out.println("Changing temperature to >>>>>>>>>>>>." + temperature);
        weatherStationObservable.setTemperature(temperature);
    }
}
