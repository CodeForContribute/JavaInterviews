package DesignWareHouseManagement;

import java.util.Map;

public class WareHouse {
    private WareHouseInventory wareHouseInventory;
    public Address address;
    public void removeItemFromInventory(Map<Integer,Integer> productIntegerMap){
        this.wareHouseInventory.removeItems(productIntegerMap);
    }
    public void addItemToInventory(Map<Integer,Integer>productCategoryAndCountMap){
        // it will update the items in the inventory based upon product category
    }

    public WareHouseInventory getWareHouseInventory() {
        return wareHouseInventory;
    }

    public void setWareHouseInventory(WareHouseInventory wareHouseInventory) {
        this.wareHouseInventory = wareHouseInventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
