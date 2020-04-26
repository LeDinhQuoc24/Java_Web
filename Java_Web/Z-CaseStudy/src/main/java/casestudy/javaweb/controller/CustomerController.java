package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.CustomerType;
import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.service.CustomerService;
import casestudy.javaweb.persistence.service.CustomerTypeService;
import casestudy.javaweb.persistence.service.ImageService;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("images")
    public List<Image> images() {
        return imageService.findByTypeContaining("Customer");
    }
    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("customers")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findByFullNameContaining(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("customer/listCustomer", "customers", customers);
    }

    @GetMapping("createCustomer")
    public ModelAndView showFormCreate() {
        return new ModelAndView("customer/createCustomer", "customer", new Customer());
    }

    @PostMapping("createCustomer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer, Pageable pageable) {
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
        modelAndView.addObject("message", "New Customer created successfully");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("editCustomer/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/editCustomer", "customer", customer);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editCustomer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer, Pageable pageable) {
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
        modelAndView.addObject("message", "Customer updated successfully");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("deleteCustomer/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/deleteCustomer", "customer", customer);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteCustomer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

    @GetMapping("viewCustomer/{id}")
    public ModelAndView viewCustomer(@PathVariable("id")Long id) {
        Customer customer=customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/viewCustomer", "customer", customer);
        }
        return new ModelAndView("error.404");
    }
}
