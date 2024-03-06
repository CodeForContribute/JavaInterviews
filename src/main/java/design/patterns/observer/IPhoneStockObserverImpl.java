package design.patterns.observer;
import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObserverImpl implements StockObservable{
    private final List<StockObserver>stockObserverList;
    private int stockCount;

    public IPhoneStockObserverImpl() {
        this.stockCount = 0;
        this.stockObserverList = new ArrayList<>();
    }

    @Override
    public void addObserver(StockObserver stockObserver) {
        this.stockObserverList.add(stockObserver);
    }

    @Override
    public void removeObserver(StockObserver stockObserver) {
        this.stockObserverList.remove(stockObserver);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver stockObserver:stockObserverList){
            stockObserver.updateStockCount();;
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
        this.notifyObservers();
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
