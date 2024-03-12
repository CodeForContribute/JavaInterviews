package DesignPatterns;

public class MobileAlertObserverImpl implements StockObserver{
    private int stockCount;
    private String mobilePhoneNumber;
    private final StockObservable stockObservable;

    public MobileAlertObserverImpl(String mobilePhoneNumber,StockObservable stockObservable) {
        this.stockCount = 0;
        this.stockObservable = stockObservable;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void sendSMS(String mobilePhoneNumber, String msg){
        System.out.println("SMS sent to: " + mobilePhoneNumber);
        // send the actual email to the end user.
    }

    @Override
    public void updateStockCount() {
        this.stockCount = this.stockObservable.getStockCount();
        if (this.stockCount == 0){
            String msg = "Iphone got out of stock !!!";
            System.out.println(msg);
            sendSMS(mobilePhoneNumber,msg);
        }else{
            String msg = "Iphone is in stock, Hurry Up !!!";
            System.out.println(msg);
            sendSMS(mobilePhoneNumber,msg);
            System.out.println("Total iphone in stocks is : " + this.stockCount);
        }
    }
}
