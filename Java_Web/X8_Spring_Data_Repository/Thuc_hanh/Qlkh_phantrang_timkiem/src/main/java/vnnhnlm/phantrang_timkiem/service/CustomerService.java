package vnnhnlm.phantrang_timkiem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vnnhnlm.phantrang_timkiem.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    void save(Customer customer);

    void remove(Long id);

}
