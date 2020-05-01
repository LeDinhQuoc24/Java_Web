package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.CustomerType;
import casestudy.javaweb.persistence.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("customerTypes")
    public ModelAndView listCustomerType() {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        return new ModelAndView("customerType/listCustomerType", "customerTypes", customerTypes);
    }

    @GetMapping("createCustomerType")
    public ModelAndView showFormCreate() {
        return new ModelAndView("customerType/createCustomerType", "customerType", new CustomerType());
    }

    @PostMapping("createCustomerType")
    public ModelAndView saveCustomerType(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.save(customerType);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("customerType/listCustomerType");
        modelAndView.addObject("message", "New CustomerType created successfully");
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

    @GetMapping("editCustomerType/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        CustomerType customerType = customerTypeService.findById(id);
        if (customerType != null) {
            return new ModelAndView("customerType/editCustomerType", "customerType", customerType);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editCustomerType")
    public ModelAndView updateCustomerType(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.save(customerType);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("customerType/listCustomerType");
        modelAndView.addObject("message", "CustomerType updated successfully");
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

    @GetMapping("deleteCustomerType/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        CustomerType customerType = customerTypeService.findById(id);
        if (customerType != null) {
            return new ModelAndView("customerType/deleteCustomerType", "customerType", customerType);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deleteCustomerType")
    public String deleteCustomerType(@ModelAttribute("customerType")CustomerType customerType, RedirectAttributes redirectAttributes) {
        customerTypeService.remove(customerType.getId());
        redirectAttributes.addFlashAttribute("message","CustomerType deleted successfully");
        return "redirect:customerTypes";
    }
    @GetMapping("deleteAllCustomerTypes")
    public String deleteAllCustomerTypes(RedirectAttributes redirectAttributes) {
        for (CustomerType customerType : customerTypeService.findAll()) {
            customerTypeService.remove(customerType.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All customerTypes deleted successfully");
        return "redirect:customerTypes";
    }
}
