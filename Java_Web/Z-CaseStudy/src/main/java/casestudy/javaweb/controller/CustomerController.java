package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.*;
import casestudy.javaweb.persistence.service.CustomerService;
import casestudy.javaweb.persistence.service.CustomerTypeService;
import casestudy.javaweb.persistence.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView saveCustomer(@Validated @ModelAttribute("customer") Customer customer,BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/customer/createCustomer");
            modelAndView.addObject("message", "New Customer created not successfully");
        } else {
            customerService.save(customer);
            Page<Customer> customers = customerService.findAll(pageable);
            modelAndView = new ModelAndView("customer/listCustomer");
            modelAndView.addObject("message", "New Customer created successfully");
            modelAndView.addObject("customers", customers);
        }
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
    public ModelAndView updateCustomer(@Validated @ModelAttribute("customer") Customer customer,BindingResult bindingResult,Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/customer/editCustomer");
            modelAndView.addObject("message", "Customer updated not successfully");
        } else {
            customerService.save(customer);
            Page<Customer> customers = customerService.findAll(pageable);
            modelAndView = new ModelAndView("customer/listCustomer");
            modelAndView.addObject("message", "Customer updated successfully");
            modelAndView.addObject("customers", customers);
        }
        return modelAndView;
    }

    @GetMapping("/deleteCustomer/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/deleteCustomer", "customer", customer);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteCustomer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message","Customer deleted successfully");
        return "redirect:customers";
    }
    @GetMapping("deleteAllCustomers")
    public String deleteAllCustomers(RedirectAttributes redirectAttributes,Pageable pageable) {
        for (Customer customer : customerService.findAll(pageable)) {
            customerService.remove(customer.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All customers deleted successfully");
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
