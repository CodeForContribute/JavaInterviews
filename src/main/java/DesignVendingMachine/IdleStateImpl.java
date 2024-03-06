package DesignVendingMachine;

import java.util.List;

import java.util.ArrayList;

public class IdleStateImpl implements State{

    public IdleStateImpl() {
        System.out.println("Currently vending machine is in idle state !!");
    }

    public IdleStateImpl(VendingMachine machine){
        System.out.println("Currently vending machine is in idle state !!");
        machine.setCoinList(new ArrayList());

    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyStateImpl());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you can not insert coin in idle state");

    }
    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first u need to click on insert coin button");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("you can not choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("product can not be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        machine.getInventory().addItem(item, productCode);
    }
}
