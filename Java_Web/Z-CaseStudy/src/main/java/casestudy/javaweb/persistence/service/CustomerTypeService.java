package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.CustomerType;


import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Long id);

    void save(CustomerType customerType);

    void remove(Long id);
}
