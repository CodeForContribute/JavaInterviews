package design.patterns.observer;

public class EmailAlertObserverImpl implements StockObserver{
    private final StockObservable stockObservable;
    private int stockCount;
    private String emailId;

    public EmailAlertObserverImpl(String emailId,StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.stockCount = 0;
        this.emailId = emailId;
    }

    public void sendMail(String emailId, String msg){
        System.out.println("Mail sent to: " + emailId);
        // send the actual email to the end user.
    }
    @Override
    public void updateStockCount() {
        this.stockCount = this.stockObservable.getStockCount();
        if (this.stockCount == 0){
            String msg = "Iphone got out of stock !!!";
            System.out.println(msg);
            sendMail(emailId,msg);
        }else{
            String msg = "Iphone is in stock, Hurry Up !!!";
            System.out.println(msg);
            sendMail(emailId,msg);
            System.out.println("Total iphone in stocks is : " + this.stockCount);
        }
    }
}
