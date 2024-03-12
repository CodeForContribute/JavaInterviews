package DesignPatterns;

public class StockObserverPatternDemo {
    public static void main(String[] args) {
        StockObservable iPhoneStockObserver = new IPhoneStockObserverImpl();
        StockObserver emailAlertObserver = new EmailAlertObserverImpl("ping.raushan@gmail.com",iPhoneStockObserver);
        StockObserver mobileAlertObserver = new MobileAlertObserverImpl("7018958256",iPhoneStockObserver);
        iPhoneStockObserver.addObserver(emailAlertObserver);
        iPhoneStockObserver.addObserver(mobileAlertObserver);

        System.out.println("Setting the iphone Count in stock to 89 >>>>>>>>>>>>");
        int stockCount = 89;
        iPhoneStockObserver.setStockCount(stockCount);

        System.out.println("Setting the iphone Count in stock to 0 >>>>>>>>>>>>");
        stockCount = 0;
        iPhoneStockObserver.setStockCount(stockCount);
    }
}
