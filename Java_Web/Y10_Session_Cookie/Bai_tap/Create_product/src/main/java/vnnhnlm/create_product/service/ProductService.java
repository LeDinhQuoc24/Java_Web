package vnnhnlm.create_product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vnnhnlm.create_product.model.Product;

import java.util.List;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();


    Product findById(Long id);

    void save(Product product);

    void remove(Long id);


}
