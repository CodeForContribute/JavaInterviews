package DesignWareHouseManagement;

import DesignBookMyShow.Payment;

import java.util.Map;

public class Order {
    private User user;
    private Address deliveryAddress;
    private Map<Integer, Integer> productCategoryAndCountMap;
    private WareHouse wareHouse;
    private Invoice invoice;
    private Payment payment;
    private OrderStatus orderStatus;

    public Order(User user, WareHouse wareHouse) {
        this.user = user;
        this.wareHouse = wareHouse;
        this.productCategoryAndCountMap = user.getCartDetails().getCartItems();
        this.deliveryAddress = user.getAddress();
        this.invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkOut() {
        // 1. update inventory
        this.wareHouse.removeItemFromInventory(productCategoryAndCountMap);
        // 2. make payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());
        // 3. make cart empty
        if (isPaymentSuccess) {
            this.user.getCartDetails().emptyCart();
            ;
        } else {
            this.wareHouse.addItemToInventory(productCategoryAndCountMap);
        }
    }

    private boolean makePayment(PaymentMode upiPaymentMode) {
        this.payment = new Payment(upiPaymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        this.invoice.generateInvoice(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Map<Integer, Integer> getProductCategoryAndCountMap() {
        return productCategoryAndCountMap;
    }

    public void setProductCategoryAndCountMap(Map<Integer, Integer> productCategoryAndCountMap) {
        this.productCategoryAndCountMap = productCategoryAndCountMap;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
