package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);
}
