package DesignWareHouseManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderController {
    private List<Order> orderList;
    private Map<Integer, List<Order>> userIdVsOrders;

    public Order createOrder(User user, WareHouse wareHouse) {
        Order order = new Order(user, wareHouse);
        this.orderList.add(order);
        List<Order> userOrders;
        if (userIdVsOrders.containsKey(user.getUserId())) {
            userOrders = this.userIdVsOrders.get(user.getUserId());
        } else {
            userOrders = new ArrayList<>();
        }
        userOrders.add(order);
        this.userIdVsOrders.put(user.getUserId(), userOrders);
        return order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Map<Integer, List<Order>> getUserIdVsOrders() {
        return userIdVsOrders;
    }

    public void setUserIdVsOrders(Map<Integer, List<Order>> userIdVsOrders) {
        this.userIdVsOrders = userIdVsOrders;
    }

    // remove order
    public void removeOrder(Order order) {
        // remove order capability goes here
    }

    public List<Order> getOrderByCustomerId(int userId) {
        return null;
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }
}
