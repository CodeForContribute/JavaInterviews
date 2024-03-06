package design.patterns.observer;

public class TVDisplayObserver implements DisplayObserver{
    private int temperature;
    private final WeatherStationObservable weatherStationObservable;

    public TVDisplayObserver(WeatherStationObservable weatherStationObservable) {
        this.weatherStationObservable = weatherStationObservable;
    }

    @Override
    public void updateTemperature() {
        this.temperature = this.weatherStationObservable.getTemperature();
        System.out.println("temperature received by Tv Display Observer " + temperature);
    }
}
