package vnnhnlm.exam.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vnnhnlm.exam.persistence.entity.Employee;

import java.util.Date;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);
    Page<Employee> findByCodeEmployeeContaining(String codeEmployee, Pageable pageable);
    Page<Employee> findByBirthContaining(Date birth, Pageable pageable);
    Page<Employee> findByIdNumberContaining(String idNumber, Pageable pageable);
}
