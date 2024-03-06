package design.patterns.facade;


class UserAuthentication{
    public void login(String username,String password){
        System.out.println("User logged in >>>>");
    }
    public void logOut(){
        System.out.println("User logged Out >>>>>");
    }
}

class PaymentProcessing{
    public void processPayment(String paymentMethod){
        System.out.println("Payment processed >>>>>");
    }
}

class InventoryManagement{
    public void updateInventory(String productId,int quantity){
        System.out.println("Inventory updated >>>>>");
    }
}

class OrderFulfillment{
    public void fulfillOrder(String orderId){
        System.out.println("Order fulfilled >>>>>>>>");
    }
}

class EcommerceFacade{
    private final UserAuthentication userAuthentication;
    private final PaymentProcessing paymentProcessing;
    private final InventoryManagement inventoryManagement;
    private final OrderFulfillment orderFulfillment;
    public EcommerceFacade(UserAuthentication userAuthentication,
                           PaymentProcessing paymentProcessing,
                           InventoryManagement inventoryManagement,
                           OrderFulfillment orderFulfillment){
        this.inventoryManagement = inventoryManagement;
        this.userAuthentication = userAuthentication;
        this.orderFulfillment = orderFulfillment;
        this.paymentProcessing = paymentProcessing;
    }

    public void purchaseProduct(String username,
                                String password,
                                String paymentMethod,
                                String productId,
                                int quantity){
        System.out.println("Processing payment for user >>>> " + username);
        userAuthentication.login(username,password);
        paymentProcessing.processPayment(paymentMethod);
        inventoryManagement.updateInventory(productId,quantity);
        orderFulfillment.fulfillOrder(productId);
        userAuthentication.logOut();
    }
}

class CustomerAccount{

    public void debitAccount(String fromAccount, String toAccount) {
    }
}
class Transactions{

    public void creditAccount(String toAccount, double amount) {
    }

    public void recordTransaction(String fromAccount, String toAccount, double amount) {
    }
}

class Audit{

    public void logTransaction(String fromAccount, String toAccount, double amount) {
    }
}
class BankingFacade{
    private final CustomerAccount customerAccount;
    private final Transactions transactions;
    private final Audit audit;

    public BankingFacade(CustomerAccount customerAccount, Transactions transactions, Audit audit) {
        this.customerAccount = customerAccount;
        this.transactions = transactions;
        this.audit = audit;
    }
    public void makeTransaction(String fromAccount,
                                String toAccount,
                                double amount){
        customerAccount.debitAccount(fromAccount, toAccount);
        transactions.creditAccount(toAccount,amount);
        transactions.recordTransaction(fromAccount,toAccount,amount);
        audit.logTransaction(fromAccount,toAccount,amount);
    }
}
public class FacadeDesignDemoClient {
    public static void main(String[] args) {
        String username = "krishna",password = "hare",paymentMethod = "UPI",productId = "1";
        int quantity = 100;
        UserAuthentication userAuthentication = new UserAuthentication();
        OrderFulfillment orderFulfillment = new OrderFulfillment();
        PaymentProcessing paymentProcessing = new PaymentProcessing();
        InventoryManagement inventoryManagement = new InventoryManagement();
        EcommerceFacade ecommerceFacade = new EcommerceFacade(userAuthentication, paymentProcessing,inventoryManagement,orderFulfillment);
        ecommerceFacade.purchaseProduct(username,password,paymentMethod,productId,quantity);
        // The facade pattern shines in dealing with legacy systems - older systems
        // that may be difficult to work with due to outdated technologies,tangled codebases,
        // lack of docs.
    }
}
