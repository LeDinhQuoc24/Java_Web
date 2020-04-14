package vnnhnlm.demo_springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vnnhnlm.demo_springboot.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}