package vnnhnlm.create_product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vnnhnlm.create_product.model.Product;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    List<Product> findAll();
}
