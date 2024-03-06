package DesignVendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin>coinList;

    public VendingMachine() {
        this.vendingMachineState = new IdleStateImpl();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList();
    }
    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public State getVendingMachineState(){
        return this.vendingMachineState;
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public List<Coin>getCoinList(){
        return coinList;
    }
    public void setCoinList(List<Coin>coinList){
        this.coinList = coinList;
    }
}
