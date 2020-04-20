package vnnhnlm.create_product.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products=new ArrayList<Product>();
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addToCart(Product product) {
        products.add(product);
    }
    public void removeFromCart(int id) {
        for(Product product : products){
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
    }
}
