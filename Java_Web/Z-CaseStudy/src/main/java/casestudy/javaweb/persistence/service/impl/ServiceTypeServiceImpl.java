package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.ServiceType;
import casestudy.javaweb.persistence.repository.ServiceTypeRepository;
import casestudy.javaweb.persistence.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Long id) {
        serviceTypeRepository.deleteById(id);
    }
}
