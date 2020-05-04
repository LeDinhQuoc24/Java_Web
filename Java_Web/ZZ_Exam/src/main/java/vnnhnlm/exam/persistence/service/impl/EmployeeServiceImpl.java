package vnnhnlm.exam.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vnnhnlm.exam.persistence.entity.Employee;
import vnnhnlm.exam.persistence.repository.EmployeeRepository;
import vnnhnlm.exam.persistence.service.EmployeeService;

import java.util.Date;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByFullNameContaining(String fullName, Pageable pageable) {
        return employeeRepository.findByFullNameContaining(fullName, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Page<Employee> findByCodeEmployeeContaining(String codeEmployee, Pageable pageable) {
        return employeeRepository.findByCodeEmployeeContaining(codeEmployee,pageable);
    }

    @Override
    public Page<Employee> findByBirthContaining(Date birth, Pageable pageable) {
        return employeeRepository.findByBirthContaining(birth,pageable);
    }

    @Override
    public Page<Employee> findByIdNumberContaining(String idNumber, Pageable pageable) {
        return employeeRepository.findByIdNumberContaining(idNumber,pageable);
    }
}
