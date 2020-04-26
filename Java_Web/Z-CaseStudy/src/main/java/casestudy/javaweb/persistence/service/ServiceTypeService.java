package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();


    ServiceType findById(Long id);

    void save(ServiceType serviceType);

    void remove(Long id);
}
