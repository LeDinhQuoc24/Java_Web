package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findByFullNameContaining(String fullName, Pageable pageable);
}
