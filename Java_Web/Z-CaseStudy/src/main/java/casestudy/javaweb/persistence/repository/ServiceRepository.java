package casestudy.javaweb.persistence.repository;


import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service,Long> {
}
