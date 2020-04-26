package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);
}
