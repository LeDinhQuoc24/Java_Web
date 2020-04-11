package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> listProduct;

    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"Chuot quang Logitech B100",54000,"img/1.png","VietNam"));
        listProduct.put(2,new Product(2,"Chuot quang Logitech G102",362000,"img/2.png","Korea"));
        listProduct.put(3,new Product(3,"Chuot khong day 6D 7500",39000,"img/3.png","Taiwan"));
        listProduct.put(4,new Product(4,"Chuot khong day Logitech B175",151000,"img/4.png","China"));
        listProduct.put(4,new Product(5,"Chuot quang Fuhlen L102",45000,"img/5.png","USA"));
        listProduct.put(4,new Product(6,"Chuot Game Led 7 Mau",25000,"img/6.png","EU"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id,product);

    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);

    }
}