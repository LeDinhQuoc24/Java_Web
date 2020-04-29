package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();


    RentType findById(Long id);

    void save(RentType rentType);

    void remove(Long id);
}
