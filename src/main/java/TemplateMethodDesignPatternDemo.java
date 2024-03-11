abstract class PaymentFlow{
    public abstract void validateRequest();
    public abstract void debitAmount();
    public abstract void calculateFee();
    public abstract void creditAmount();

    // Template method
    public final void sendMoney(){
        validateRequest();
        debitAmount();
        calculateFee();
        creditAmount();
    }
}

class PayToFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validating request for friend !!!");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount for friend !!!!");
    }

    @Override
    public void calculateFee() {
        System.out.println(" calculating fee for friend - 0% !!!");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount for friend !!!!");
    }
}


class PayToMerchantFlow extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validating request for merchant !!!");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount for merchant !!!!");
    }

    @Override
    public void calculateFee() {
        System.out.println(" calculating fee for merchant - 10% !!!");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount for merchant !!!!");
    }
}
public class TemplateMethodDesignPatternDemo {
    /*
    * Why it is required
    *  - when u want all classes to follow the specific steps to process the task in certain order
    *   but implementations could be different of each method.
    * */
    public static void main(String[] args) {
        PayToFriend payToFriend = new PayToFriend();
        payToFriend.sendMoney();
        System.out.println();
        PayToMerchantFlow payToMerchantFlow = new PayToMerchantFlow();
        payToMerchantFlow.sendMoney();
    }


}
