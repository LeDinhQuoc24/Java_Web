package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    Page<Service> findByServiceType_Name(String name, Pageable pageable);

    Page<Service> findByNameContaining(String name, Pageable pageable);

    Service findById(Long id);

    void save(Service service);

    void remove(Long id);
}
