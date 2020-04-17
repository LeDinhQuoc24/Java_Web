package vnnhnlm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vnnhnlm.model.Customer;
import vnnhnlm.repository.CustomerRepository;
import vnnhnlm.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
