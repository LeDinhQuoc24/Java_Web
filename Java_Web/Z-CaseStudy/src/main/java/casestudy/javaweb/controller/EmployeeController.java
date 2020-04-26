package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.*;
import casestudy.javaweb.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private DegreeService degreeService;
    @Autowired
    private PartService partService;
    @Autowired
    private PositionService positionService;

    @ModelAttribute("images")
    public List<Image> images() {
        return imageService.findByTypeContaining("Employee");
    }
    @ModelAttribute("degrees")
    public List<Degree> degrees() {
        return degreeService.findAll();
    }
    @ModelAttribute("parts")
    public List<Part> parts() {
        return partService.findAll();
    }
    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.findAll();
    }

    @GetMapping("employees")
    public ModelAndView listEmployee(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees;
        if (s.isPresent()) {
            employees = employeeService.findByFullNameContaining(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        return new ModelAndView("employee/listEmployee", "employees", employees);
    }

    @GetMapping("createEmployee")
    public ModelAndView showFormCreate() {
        return new ModelAndView("employee/createEmployee", "employee", new Employee());
    }

    @PostMapping("createEmployee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee, Pageable pageable) {
        employeeService.save(employee);
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/listEmployee");
        modelAndView.addObject("message", "New Employee created successfully");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("editEmployee/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return new ModelAndView("employee/editEmployee", "employee", employee);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editEmployee")
    public ModelAndView updateCustomer(@ModelAttribute("employee") Employee employee, Pageable pageable) {
        employeeService.save(employee);
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/listEmployee");
        modelAndView.addObject("message", "Employee updated successfully");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("deleteEmployee/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return new ModelAndView("employee/deleteEmployee", "employee", employee);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteEmployee")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.remove(employee.getId());
        return "redirect:employees";
    }

    @GetMapping("viewEmployee/{id}")
    public ModelAndView viewEmployee(@PathVariable("id")Long id) {
        Employee employee=employeeService.findById(id);
        if (employee != null) {
            return new ModelAndView("employee/viewEmployee", "employee", employee);
        }
        return new ModelAndView("error.404");
    }
}
