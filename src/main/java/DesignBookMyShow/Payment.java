package DesignBookMyShow;

import DesignWareHouseManagement.PaymentMode;

public class Payment {
    private PaymentMode paymentMode;
    public Payment(PaymentMode paymentMode){
        this.paymentMode = paymentMode;
    }
    public boolean makePayment(){
        return this.paymentMode.makePayment();
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
