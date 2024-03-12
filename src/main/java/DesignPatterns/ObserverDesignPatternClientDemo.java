package DesignPatterns;

import java.util.ArrayList;
import java.util.List;
/**
 * In observer pattern , we generally 2 things
 * a. Observable
 * b. Observer
 * One observable can be observed by 1 to many observers.
 * */

interface Observer{
    public void update();
}
interface Observable{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
    public void setData(int data);
    public int getData();
}

class ObservableImpl implements Observable{
    private int data;
    private final List<Observer>observers;

    public ObservableImpl() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        this.observers.forEach(Observer::update);
    }

    public void setData(int data) {
        this.data = data;
        this.notifyObserver();
    }

    @Override
    public int getData() {
        return 0;
    }
}

class ObserverImpl implements Observer{

    // Observer will be having
    private final Observable observable;

    public ObserverImpl(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        int data = this.observable.getData();
        System.out.println("data received >>>>>>>>> : " + data);
    }
}

public class ObserverDesignPatternClientDemo {
    public static void main(String[] args) {
        Observable observable = new ObservableImpl();
        Observer o1 = new ObserverImpl(observable);
        Observer o2 = new ObserverImpl(observable);
        Observer o3 = new ObserverImpl(observable);
        observable.addObserver(o1);
        observable.addObserver(o2);
        observable.addObserver(o3);
        observable.setData(20);
        observable.removeObserver(o2);
        observable.setData(2000);
    }
}
