package vnnhnlm.demo_springboot.service;




import vnnhnlm.demo_springboot.model.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);


}