package vnnhnlm.exam.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vnnhnlm.exam.persistence.entity.Employee;

import java.util.Date;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findByCodeEmployeeContaining(String codeEmployee, Pageable pageable);
    Page<Employee> findByBirthContaining(Date birth, Pageable pageable);
    Page<Employee> findByIdNumberContaining(String idNumber, Pageable pageable);

}
