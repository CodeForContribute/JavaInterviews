package design.patterns.observer;

public class MobileDisplayObserver implements DisplayObserver{
    private final WeatherStationObservable weatherStationObservable;

    public MobileDisplayObserver(WeatherStationObservable weatherStationObservable){
        this.weatherStationObservable = weatherStationObservable;
    }
    @Override
    public void updateTemperature() {
        int temperature = this.weatherStationObservable.getTemperature();
        System.out.println("Temperature received by Mobile Display Observer: " + temperature);
    }
}
