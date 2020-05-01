package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.*;
import casestudy.javaweb.persistence.service.RentTypeService;
import casestudy.javaweb.persistence.service.ServiceService;
import casestudy.javaweb.persistence.service.ServiceTypeService;
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
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @ModelAttribute("listLike")
    public ListLike setUpForm() {
        return new ListLike();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> rentTypes() {
        return rentTypeService.findAll();
    }
    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @GetMapping("services")
    public ModelAndView listService(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {

        Page<Service> services;
        if (s.isPresent()) {
            services = serviceService.findByNameContaining(s.get(),pageable);
        } else {
            services= serviceService.findAll(pageable);
        }
        return new ModelAndView("service/listService","services", services);
    }
    @GetMapping("services/{name}")
    public ModelAndView listVilla(@PathVariable("name") String name,@PageableDefault(value=5) Pageable pageable) {
        Page<Service> services = serviceService.findByServiceType_Name(name, pageable);
        return new ModelAndView("service/listService", "services", services);
    }


    @GetMapping("createService")
    public ModelAndView showFormCreate() {
        return new ModelAndView("service/createService", "service", new Service());
    }

    @PostMapping("create-service")
    public ModelAndView createService(@ModelAttribute("service")Service service,Pageable pageable) {
        serviceService.save(service);
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("service/listService");
        modelAndView.addObject("services", services);
        modelAndView.addObject("message", "New Service created successfully");
        return modelAndView;
    }

    @PostMapping("createService")
    public ModelAndView createService(@Validated @ModelAttribute("service")Service service, BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/service/createService");
            modelAndView.addObject("message", "New Service created not successfully");
        } else {
            serviceService.save(service);
            Page<Service> services = serviceService.findAll(pageable);
            modelAndView= new ModelAndView("service/listService");
            modelAndView.addObject("services", services);
            modelAndView.addObject("message", "New Service created successfully");
        }
        return modelAndView;
    }

    @GetMapping("editService/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service!=null) {
            return new ModelAndView("service/editService", "service", service);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editService")
    public ModelAndView saveService(@Validated @ModelAttribute("service") Service service,BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/service/editService");
            modelAndView.addObject("message", "Service updated not successfully");
        } else {
            serviceService.save(service);
            Page<Service> services = serviceService.findAll(pageable);
            modelAndView = new ModelAndView("service/listService");
            modelAndView.addObject("services", services);
            modelAndView.addObject("message", "Service updated successfully");
        }

        return modelAndView;
    }

    @GetMapping("deleteService/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service!=null) {
            return new ModelAndView("service/deleteService", "service", service);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteService")
    public String deleteService(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        serviceService.remove(service.getId());
        redirectAttributes.addFlashAttribute("message","Service deleted successfully");
        return "redirect:services";
    }
    @GetMapping("deleteAllServices")
    public String deleteAllServices(RedirectAttributes redirectAttributes,Pageable pageable) {
        for (Service service : serviceService.findAll(pageable)) {
            serviceService.remove(service.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All services deleted successfully");
        return "redirect:services";
    }

    @GetMapping("viewService/{id}")
    public ModelAndView viewService(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service!=null) {
            return new ModelAndView("service/viewService", "service", service);
        }
        return new ModelAndView("error.404");
    }

}
