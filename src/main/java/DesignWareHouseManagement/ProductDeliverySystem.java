package DesignWareHouseManagement;

public class ProductDeliverySystem {
    private UserController userController;
    private WareHouseController wareHouseController;
    private OrderController orderController;

    public ProductDeliverySystem(UserController userController, WareHouseController wareHouseController, OrderController orderController) {
        this.userController = userController;
        this.wareHouseController = wareHouseController;
        this.orderController = orderController;
    }

    // get user object
    public User getUser(int userId){
        return this.userController.getUser(userId);
    }
    // get wareHouse
    public WareHouse getWareHouse(WareHouseSelectionStrategy wareHouseSelectionStrategy){
        return this.wareHouseController.selectWareHouse(wareHouseSelectionStrategy);
    }
    // get inventory
    public WareHouseInventory getWareHouseInventory(WareHouse wareHouse){
        return wareHouse.getWareHouseInventory();
    }
    // add product to cart
    public void addProductToCart(User user, ProductCategory productCategory, int count){
        Cart cart = user.getCartDetails();
        cart.addItemInCart(productCategory.getProductCategoryId(),count);
    }
    public Order placeOrder(User user, WareHouse wareHouse){
        return this.orderController.createOrder(user, wareHouse);
    }
    public void checkOut(Order order){
        order.checkOut();
    }
    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public WareHouseController getWareHouseController() {
        return wareHouseController;
    }

    public void setWareHouseController(WareHouseController wareHouseController) {
        this.wareHouseController = wareHouseController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
