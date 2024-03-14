package DesignWareHouseManagement;


import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private int productCategoryId;
    private String categoryName;
    private Double price;
    private List<Product>productList = new ArrayList<>();

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        this.productList.add(product);
    }
    public void removeProduct(int count){
        for (int i = 1 ; i<= count;++i){
            this.productList.remove(0);
        }
    }
}
