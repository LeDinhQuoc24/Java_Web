package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Service;
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
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("services")
    public ModelAndView listService(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Service> services;
        if (s.isPresent()) {
            services = serviceService.findByNameContaining(s.get(),pageable);
        } else {
            services= serviceService.findAll(pageable);
        }
        return new ModelAndView("service/listService", "services", services);
    }

    @GetMapping("createService")
    public ModelAndView showFormCreate() {
        return new ModelAndView("service/createService", "service", new Service());
    }

    @PostMapping("createService")
    public ModelAndView createService(@ModelAttribute("service") Service service, Pageable pageable) {
        serviceService.save(service);
        ModelAndView modelAndView= new ModelAndView("service/listService");
        Page<Service> services = serviceService.findAll(pageable);
        modelAndView.addObject("services", services);
        modelAndView.addObject("message", "New Service created successfully");
        return modelAndView;
    }

    @GetMapping("editService/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service.getTypeService().equals("Villa")) {
            return new ModelAndView("service/editVilla", "service", service);
        } else if (service.getTypeService().equals("House")) {
            return new ModelAndView("service/editHouse", "service", service);
        } else if (service.getTypeService().equals("Room")) {
            return new ModelAndView("service/editRoom", "service", service);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editService")
    public ModelAndView saveService(@ModelAttribute("service") Service service, Pageable pageable) {
        serviceService.save(service);
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/listService");
        modelAndView.addObject("services", services);
        modelAndView.addObject("message", "Service updated successfully");
        return modelAndView;
    }

    @GetMapping("deleteService/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service.getTypeService().equals("Villa")) {
            return new ModelAndView("service/deleteVilla", "service", service);
        } else if (service.getTypeService().equals("House")) {
            return new ModelAndView("service/deleteHouse", "service", service);
        } else if (service.getTypeService().equals("Room")) {
            return new ModelAndView("service/deleteRoom", "service", service);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("deleteService")
    public String deleteService(@ModelAttribute("service") Service service) {
        serviceService.remove(service.getId());
        return "redirect:services";
    }

    @GetMapping("viewService/{id}")
    public ModelAndView viewService(@PathVariable("id") Long id) {
        Service service = serviceService.findById(id);
        if (service.getTypeService().equals("Villa")) {
            return new ModelAndView("service/viewVilla", "service", service);
        } else if (service.getTypeService().equals("House")) {
            return new ModelAndView("service/viewHouse", "service", service);
        } else if (service.getTypeService().equals("Room")) {
            return new ModelAndView("service/viewRoom", "service", service);
        }
        return new ModelAndView("error.404");
    }

    @GetMapping("services/{typeService}")
    public ModelAndView listVilla(@PathVariable("typeService") String typeService,@PageableDefault(value=5) Pageable pageable) {
        Page<Service> services = serviceService.findByTypeServiceContaining(typeService, pageable);
        return new ModelAndView("service/listService", "services", services);
    }
}
