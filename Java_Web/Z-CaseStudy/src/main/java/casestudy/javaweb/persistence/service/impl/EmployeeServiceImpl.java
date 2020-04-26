package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.Employee;
import casestudy.javaweb.persistence.repository.EmployeeRepository;
import casestudy.javaweb.persistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
