package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public ModelAndView listServies(Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        return new ModelAndView("service/listService", "services", services);
    }
    @GetMapping("create-service")
    public ModelAndView showFormCreate() {
        return new ModelAndView("service/create_service", "service", new Service());
    }
    @PostMapping("create-service")
    public ModelAndView createService(@ModelAttribute("service")Service service,Pageable pageable) {
        serviceService.save(service);
        ModelAndView modelAndView;
        Page<Service> services = serviceService.findAll(pageable);
        modelAndView=new ModelAndView("service/listService");
        modelAndView.addObject("services", services);
        modelAndView.addObject("message", "New Service created successfully");

        return modelAndView;
    }
}
