package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    Service findById(Long id);

    void save(Service service);

    void remove(Long id);
}
