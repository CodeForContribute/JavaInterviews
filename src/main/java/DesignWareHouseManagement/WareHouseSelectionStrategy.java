package DesignWareHouseManagement;
import java.util.List;
public abstract class WareHouseSelectionStrategy {
    public abstract WareHouse selectWareHouse(List<WareHouse>wareHouseList);
}
