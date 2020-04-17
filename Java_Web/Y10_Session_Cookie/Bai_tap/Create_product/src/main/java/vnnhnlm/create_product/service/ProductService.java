package vnnhnlm.create_product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vnnhnlm.create_product.model.Product;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);


}
