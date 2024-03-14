package DesignWareHouseManagement;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> productCategoryIdVsCountMap;

    public Cart() {
        this.productCategoryIdVsCountMap = new HashMap<>();
    }

    // add item to the cart
    public void addItemInCart(int productCategoryId, int count) {
        if (this.productCategoryIdVsCountMap.containsKey(productCategoryId)) {
            int numberItemsInCart = this.productCategoryIdVsCountMap.get(productCategoryId);
            this.productCategoryIdVsCountMap.put(productCategoryId, numberItemsInCart + count);
        } else {
            productCategoryIdVsCountMap.put(productCategoryId, count);
        }
    }

    // remove item to the cart
    public void removeItemFromCart(int productCategoryId, int count) {
        if (this.productCategoryIdVsCountMap.containsKey(productCategoryId)) {
            int numberItemsInCart = this.productCategoryIdVsCountMap.get(productCategoryId);
            if (count - numberItemsInCart == 0) {
                this.productCategoryIdVsCountMap.remove(productCategoryId);
            } else {
                this.productCategoryIdVsCountMap.put(productCategoryId, numberItemsInCart - count);
            }
        }
    }

    // empty the cart
    public void emptyCart() {
        this.productCategoryIdVsCountMap = new HashMap<>();
    }

    // view Cart
    public Map<Integer, Integer> getCartItems() {
        return this.productCategoryIdVsCountMap;
    }
}
