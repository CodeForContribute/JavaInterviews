package design.patterns.observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservableImpl implements WeatherStationObservable{
    private int temperature;
    private final List<DisplayObserver>displayObserverList;
    public WeatherStationObservableImpl(){
        this.displayObserverList = new ArrayList<>();
    }
    @Override
    public void addObserver(DisplayObserver displayObserver) {
        this.displayObserverList.add(displayObserver);
    }

    @Override
    public void removeObserver(DisplayObserver displayObserver) {
        this.displayObserverList.remove(displayObserver);
    }

    @Override
    public void notifyObservers() {
        this.displayObserverList.forEach(DisplayObserver::updateTemperature);
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }
    public int getTemperature(){
        return this.temperature;
    }
}
