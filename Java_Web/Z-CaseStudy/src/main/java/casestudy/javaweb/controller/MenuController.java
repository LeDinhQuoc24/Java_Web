package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.ListLike;
import casestudy.javaweb.persistence.entity.Service;
import casestudy.javaweb.persistence.service.ServiceService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@SessionAttributes("listLike")
@Controller
public class MenuController {
    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("listLike")
    public ListLike setUpForm() {
        return new ListLike();
    }



    @GetMapping("menu")
    public ModelAndView menu() {
        return new ModelAndView("show/menu");
    }

    @GetMapping("search")
    public ModelAndView search() {
        return new ModelAndView("show/search");
    }

    @GetMapping("image")
    public ModelAndView image() {
        return new ModelAndView("show/image");
    }

    @GetMapping("listLike")
    public ModelAndView listLike(@ModelAttribute("listLike") ListLike listLike) {
        return new ModelAndView("listLike", "listLike", listLike);
    }

    @GetMapping("listLike-add/{id}")
    public ModelAndView addListLike(@PathVariable("id")String id,@ModelAttribute("listLike") ListLike listLike) {
        ModelAndView modelAndView=new ModelAndView("listLike");
        Service service = serviceService.findById(parseLong(id));

        for (Service service1 : listLike.getServiceList()) {
            if (service1.getId() == parseLong(id)) {
                modelAndView.addObject("message", "You liked this service");
               }
        }

        listLike.addListLike(service);
        modelAndView.addObject("message", "Add successfully");
        return listLike(listLike);
    }
    @GetMapping("listLike-remove/{id}")
    public ModelAndView removeListLike(@PathVariable("id")String id,@ModelAttribute("listLike") ListLike listLike) {
        listLike.removeFromListLike(parseLong(id));
        ModelAndView modelAndView=new ModelAndView("listLike");
        modelAndView.addObject("message", "Remove successfully");
        return listLike(listLike);
    }
//    @GetMapping("services2")
//    public ModelAndView listService() {
//        List<Service> services=serviceService.findAll();
//        return new ModelAndView("service/listService", "services", services);
//    }



}
