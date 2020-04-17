package vnnhnlm.create_product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vnnhnlm.create_product.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}
