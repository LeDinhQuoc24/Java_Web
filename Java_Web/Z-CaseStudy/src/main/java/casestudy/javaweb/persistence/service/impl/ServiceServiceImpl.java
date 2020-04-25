package casestudy.javaweb.persistence.service.impl;


import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.repository.ServiceRepository;
import casestudy.javaweb.persistence.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findByTypeServiceContaining(String typeService, Pageable pageable) {
        return serviceRepository.findByTypeServiceContaining(typeService, pageable);
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
