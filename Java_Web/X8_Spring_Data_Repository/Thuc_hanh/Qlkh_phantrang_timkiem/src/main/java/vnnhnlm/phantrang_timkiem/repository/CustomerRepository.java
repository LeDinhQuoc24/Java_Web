package vnnhnlm.phantrang_timkiem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import vnnhnlm.phantrang_timkiem.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

        Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
