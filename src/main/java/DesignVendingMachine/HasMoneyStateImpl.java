package DesignVendingMachine;

import java.util.List;

public class HasMoneyStateImpl implements State{

    public HasMoneyStateImpl() {
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button now , u can cancel for refund or start the process");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        // implement logic
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        // implementation here
        machine.setVendingMachineState(new SelectionStateImpl());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("u can not choose product in this sate");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in this state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("you can not get product in this state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the coin dispense tray");
        machine.setVendingMachineState(new IdleStateImpl());
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("you can not update inventory in hasMoney state");
    }
}
