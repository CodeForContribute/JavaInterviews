package DesignWareHouseManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WareHouseInventory {
    //category wise product storage
    List<ProductCategory> productCategoryList;

    public WareHouseInventory() {
        this.productCategoryList = new ArrayList<>();
    }

    // add new category
    public void addCategory(int categoryId, String name, double price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setPrice(price);
        productCategory.setCategoryName(name);
        productCategory.setProductCategoryId(categoryId);
        productCategoryList.add(productCategory);
    }

    // add product to the particular category
    public void addProduct(Product product, int productCategoryId) {
        // take out the respective productCategory object
        ProductCategory productCategory = null;
        for (ProductCategory pc : this.productCategoryList) {
            if (pc.getProductCategoryId() == productCategoryId) {
                productCategory = pc;
            }
        }
        if (productCategory != null) {
            productCategory.addProduct(product);
        }
    }

    // remove product from the category
    public void removeItems(Map<Integer,Integer> productCategoryAndCountMap){
        for (Map.Entry<Integer,Integer>e:productCategoryAndCountMap.entrySet()){
            ProductCategory productCategory = getProductCategoryFromId(e.getKey());
            productCategory.removeProduct(e.getValue());
        }
    }
    public ProductCategory getProductCategoryFromId(int productCategoryId){
        for (ProductCategory pc:this.productCategoryList){
            if (pc.getProductCategoryId() == productCategoryId){
                return pc;
            }
        }
        return null;
    }
}
