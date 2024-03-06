package DesignVendingMachine;

import java.util.List;

public class DispenseStateImpl implements State{

    private VendingMachine machine;
    private int productCode;

    public DispenseStateImpl() {
    }

    public DispenseStateImpl(VendingMachine machine, int productCode){
        this.machine = machine;
        this.productCode = productCode;
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {

    }
}
