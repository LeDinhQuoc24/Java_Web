package vnnhnlm.udqlkh.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import vnnhnlm.udqlkh.model.Customer;
import vnnhnlm.udqlkh.repository.CustomerRepository;
import vnnhnlm.udqlkh.service.CustomerService;


public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}