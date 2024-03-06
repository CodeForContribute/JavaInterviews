package design.patterns.observer;

public interface StockObservable {
    public void addObserver(StockObserver stockObserver);

    public void removeObserver(StockObserver stockObserver);

    public void notifyObservers();

    public void setStockCount(int stockCount);
    public int getStockCount();
}
