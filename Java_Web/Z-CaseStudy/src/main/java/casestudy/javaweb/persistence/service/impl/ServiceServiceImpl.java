package casestudy.javaweb.persistence.service.impl;


import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.repository.ServiceRepository;
import casestudy.javaweb.persistence.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findByServiceType_Name(String name, Pageable pageable) {
        return serviceRepository.findByServiceType_Name(name, pageable);
    }


    @Override
    public Page<Service> findByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findByNameContaining(name, pageable);
    }

    @Override
    public casestudy.javaweb.persistence.entity.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(casestudy.javaweb.persistence.entity.Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
