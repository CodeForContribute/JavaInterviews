package DesignPatterns;

class Product {
    private int productId;
    private String productName;

    public Product(int productId) {
        this.productId = productId;
    }
}

class ProductDaoImpl {
    public Product getProduct(int productId) {
        Product product = new Product(productId);
        return product;
    }
}

class PaymentDaoImpl {
    public boolean makePayment() {
        //initiate payment
        return true;
    }
}

class InvoiceDaoImpl {
    public void generateInvoice() {
        //
    }
}

class SendNotificationDaoImpl {
    public void sendNotification() {
        //
    }
}

class OrderFacade {
    ProductDaoImpl productDaoImpl;
    InvoiceDaoImpl invoiceDaoImpl;
    PaymentDaoImpl paymentDaoImpl;
    SendNotificationDaoImpl notificationDaoImpl;

    public OrderFacade() {
        this.paymentDaoImpl = new PaymentDaoImpl();
        this.productDaoImpl = new ProductDaoImpl();
        this.invoiceDaoImpl = new InvoiceDaoImpl();
        this.notificationDaoImpl = new SendNotificationDaoImpl();
    }

    public void createOrder() {
        Product product = this.productDaoImpl.getProduct(121);
        this.paymentDaoImpl.makePayment();
        this.invoiceDaoImpl.generateInvoice();
        this.notificationDaoImpl.sendNotification();
        //order creation successful
    }
}

public class FacadeDesignPatternClientDemo {
    /*
     * It is used to hide system complexity.
     * */
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        // created order
        // here order creation complexity is hidden in Facade class
        orderFacade.createOrder();
    }


}
