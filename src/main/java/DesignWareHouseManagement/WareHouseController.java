package DesignWareHouseManagement;
import java.util.List;

public class WareHouseController {
    private List<WareHouse>wareHouseList;
    private WareHouseSelectionStrategy wareHouseSelectionStrategy;

    public WareHouseController(List<WareHouse> wareHouseList, WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseList = wareHouseList;
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
    }
    // add new warehouse
    public void addNewWareHouse(WareHouse wareHouse){
        this.wareHouseList.add(wareHouse);
    }
    // remove warehouse
    public void removeWareHouse(WareHouse wareHouse){
        this.wareHouseList.remove(wareHouse);
    }
    public WareHouse selectWareHouse(WareHouseSelectionStrategy wareHouseSelectionStrategy){
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
        return this.wareHouseSelectionStrategy.selectWareHouse(this.wareHouseList);
    }

    public List<WareHouse> getWareHouseList() {
        return wareHouseList;
    }

    public void setWareHouseList(List<WareHouse> wareHouseList) {
        this.wareHouseList = wareHouseList;
    }

    public WareHouseSelectionStrategy getWareHouseStrategy() {
        return wareHouseSelectionStrategy;
    }

    public void setWareHouseStrategy(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
    }
}
