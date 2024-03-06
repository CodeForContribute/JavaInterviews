package design.patterns.observer;

// This is Observable
public interface WeatherStationObservable {
    public void addObserver(DisplayObserver displayObserver);
    public void removeObserver(DisplayObserver displayObserver);
    public void notifyObservers();
    public void setTemperature(int temperature);
    public int getTemperature();
}


