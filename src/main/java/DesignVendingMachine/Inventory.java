package DesignVendingMachine;

public class Inventory {
    ItemShelf[]inventory = null;

    public Inventory(int totalProductCount) {
        inventory = new ItemShelf[totalProductCount];
        initializeEmptyInventory();
    }

    private void initializeEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length;++i){
            ItemShelf space = new ItemShelf();
            space.setProductCode(startCode);
            space.setSoldOut(false);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int productCode) throws Exception{
        for (ItemShelf itemShelf: inventory){
            if (itemShelf.productCode == productCode){
                if (itemShelf.isSoldOut){
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                }else{
                    throw new Exception("Already item is present, we can not add item here");
                }
            }
        }
    }

    public Item getItem(int productCode) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getProductCode() == productCode){
                return itemShelf.getItem();
            }
        }
        return null;
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }
}
