package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.repository.CustomerRepository;
import casestudy.javaweb.persistence.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByFullNameContaining(String fullName, Pageable pageable) {
        return customerRepository.findByFullNameContaining(fullName, pageable);
    }


    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
