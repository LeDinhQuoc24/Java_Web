package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.service.CustomerService;
import casestudy.javaweb.persistence.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ImageService imageService;
    @ModelAttribute("images")
    public List<Image> images() {
        return imageService.findAll();
    }

    @GetMapping("customers")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findByFullNameContaining(s.get(),pageable);
        } else {
            customers= customerService.findAll(pageable);
        }
        return new ModelAndView("customer/listCustomer", "customers", customers);
    }
    @GetMapping("createCustomer")
    public ModelAndView showFormCreate() {
        return new ModelAndView("customer/createCustomer", "customer", new Customer());
    }
    @PostMapping("createCustomer")
    public ModelAndView saveCustomer(@ModelAttribute("customer")Customer customer,Pageable pageable) {
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
        modelAndView.addObject("message", "New Customer created successfully");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
