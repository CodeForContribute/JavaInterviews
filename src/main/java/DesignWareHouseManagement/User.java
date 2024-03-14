package DesignWareHouseManagement;

import com.sun.tools.javac.util.List;

public class User {
    private int userId;
    private String userName;
    private Address address;
    private Cart cartDetails;
    private List<Integer> orderIds;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Cart cartDetails) {
        this.cartDetails = cartDetails;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
