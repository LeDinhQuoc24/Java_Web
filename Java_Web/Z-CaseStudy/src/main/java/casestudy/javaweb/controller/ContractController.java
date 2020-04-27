package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Contract;
import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Employee;
import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.service.ContractService;
import casestudy.javaweb.persistence.service.CustomerService;
import casestudy.javaweb.persistence.service.EmployeeService;
import casestudy.javaweb.persistence.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;
    @ModelAttribute("customers")
    public Page<Customer> listCustomer(Pageable pageable) {
        return customerService.findAll(pageable);
    }
    @ModelAttribute("employees")
    public Page<Employee> listEmployee(Pageable pageable) {
        return employeeService.findAll(pageable);
    }
    @ModelAttribute("services")
    public Page<Service> listService(Pageable pageable) {
        return serviceService.findAll(pageable);
    }

    @GetMapping("contracts")
    public ModelAndView listContract(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Contract> contracts;
        if (s.isPresent()) {
            contracts = contractService.findByContractNumberContaining(s.get(), pageable);
        } else {
            contracts = contractService.findAll(pageable);
        }
        return new ModelAndView("contract/listContract", "contracts", contracts);
    }

    @GetMapping("createContract")
    public ModelAndView showFormCreate() {
        return new ModelAndView("contract/createContract", "contract", new Contract());
    }

    @PostMapping("createContract")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract, Pageable pageable) {
        contractService.save(contract);
        Customer customer=contract.getCustomer();
        customer.setStatus("Registered");
        customerService.save(customer);
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/listContract");
        modelAndView.addObject("message", "New Contract created successfully");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("editContract/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Contract contract = contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/editContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editContract")
    public ModelAndView updateCustomer(@ModelAttribute("contract") Contract contract, Pageable pageable) {
        contractService.save(contract);
        Customer customer=contract.getCustomer();
        customer.setStatus("Registered");
        customerService.save(customer);
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/listContract");
        modelAndView.addObject("message", "Contract updated successfully");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("deleteContract/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Contract contract = contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/deleteContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteContract")
    public String deleteContract(@ModelAttribute("contract") Contract contract) {
        contractService.remove(contract.getId());
        return "redirect:contracts";
    }

    @GetMapping("viewContract/{id}")
    public ModelAndView viewContract(@PathVariable("id")Long id) {
        Contract contract=contractService.findById(id);
        if (contract != null) {
            return new ModelAndView("contract/viewContract", "contract", contract);
        }
        return new ModelAndView("error.404");
    }

}
