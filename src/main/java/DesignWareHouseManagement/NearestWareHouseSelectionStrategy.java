package DesignWareHouseManagement;

import java.util.List;

public class NearestWareHouseSelectionStrategy extends WareHouseSelectionStrategy{

    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouseList) {
        // algo to pick the nearest algo.
        return wareHouseList.get(0);
    }
}
