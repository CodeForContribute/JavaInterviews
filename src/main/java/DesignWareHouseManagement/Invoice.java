package DesignWareHouseManagement;

public class Invoice {
    private int totalItemPrice;
    private int totalTax;
    private int totalFinalPrice;
    // generate Invoice
    public void generateInvoice(Order order) {
        // it will compute and update the above details
        this.totalItemPrice = 200;
        this.totalTax = 20;
        this.totalFinalPrice = 220;
    }

    public int getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(int totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public int getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(int totalTax) {
        this.totalTax = totalTax;
    }

    public int getTotalFinalPrice() {
        return totalFinalPrice;
    }

    public void setTotalFinalPrice(int totalFinalPrice) {
        this.totalFinalPrice = totalFinalPrice;
    }
}
