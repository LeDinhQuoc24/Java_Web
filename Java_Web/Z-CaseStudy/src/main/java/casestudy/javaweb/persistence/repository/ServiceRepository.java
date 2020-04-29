package casestudy.javaweb.persistence.repository;


import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service,Long> {
    Page<Service> findByServiceType_Name(String name, Pageable pageable);
    Page<Service> findByNameContaining(String name, Pageable pageable);
    List<Service> findAll();

}
