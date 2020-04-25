package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByFullNameContaining(String fullName, Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
