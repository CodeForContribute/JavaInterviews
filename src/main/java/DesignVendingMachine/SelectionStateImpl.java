package DesignVendingMachine;

import java.util.List;

public class SelectionStateImpl implements State{
    public SelectionStateImpl(){
        System.out.println("currently vending machine is in selection state");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button in selection state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("u can not insert coin in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
            return;
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        // 1. get item of this productCode
        Item item = machine.getInventory().getItem(productCode);
        // 2. total amount paid by user
        int paidByUser = 0;
        for (Coin coin:machine.getCoinList()){
            paidByUser = paidByUser + coin.getValue();
        }
        // 3. compare product price and amount paid by user
        if (paidByUser < item.getPrice()){
            System.out.println("Insufficient amount for the selected product");
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        }else if (paidByUser > item.getPrice()){
            getChange(paidByUser- item.getPrice());
        }
        machine.setVendingMachineState(new DispenseStateImpl(machine,productCode));
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("returned the change in the coin dispense tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back paid by the user in coin dispense tray");
        machine.setVendingMachineState(new IdleStateImpl(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
