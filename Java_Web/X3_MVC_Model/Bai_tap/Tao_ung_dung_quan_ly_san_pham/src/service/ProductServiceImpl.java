package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Chuột quang Logitech B100",54000,10,"img/1.png"));
        products.put(2,new Product(2,"Chuột quang Logitech G102",362000,5,"img/2.png"));
        products.put(3,new Product(3,"Chuột không dây 6D 7500",39000,2,"img/3.png"));
        products.put(4,new Product(4,"Chuột không dây Logitech B175",151000,12,"img/4.png"));
        products.put(5,new Product(5,"Chuột quang Fuhlen L102",45000,8,"img/5.png"));
        products.put(6,new Product(6,"Chuột Game Led 7 Màu",25000,20,"img/6.png"));
    }



    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
