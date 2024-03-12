package DesignWareHouseManagement;

import DesignVendingMachine.Inventory;

import java.util.ArrayList;
import java.util.List;

class WareHouse{
}
class WareHouseInventory{
    public void addCategory(int i, String pepsiLargeColdDrink, int i1) {

    }
}
public class DesignWareHouseManagementClient {
    public static void main(String[] args) {
        DesignWareHouseManagementClient obj = 
                new DesignWareHouseManagementClient();
        // 1. create warehouse in the system
        // 2. create users in the system
        // 3. feed the system with the initial information
        // 4. user add product to cart and then does the order.
        List<WareHouse>wareHouseList = new ArrayList<>();
        wareHouseList.add(obj.addWareHouseAndItsInventory());
    }

    private WareHouse addWareHouseAndItsInventory() {
        WareHouse wareHouse = new WareHouse();
        WareHouseInventory inventory = new WareHouseInventory();
        inventory.addCategory(0001,"Pepsi Large Cold Drink",100);
        return wareHouse;
    }
}
