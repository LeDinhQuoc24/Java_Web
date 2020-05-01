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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import java.util.List;
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
    @GetMapping("readme")
    public ModelAndView readme() {
        return new ModelAndView("show/readme");
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
    public String addListLike(@PathVariable("id") Long id, @ModelAttribute("listLike") ListLike listLike, RedirectAttributes redirectAttributes) {
        Service service = serviceService.findById(id);
        if (service == null) {
            return "error.404";
        } else {
            for (Service service1 : listLike.getServiceList()) {
                if (service1.getId().equals(id)) {
                    redirectAttributes.addFlashAttribute("message", "You liked this service");
                    return "redirect:/services2";
                }
            }
            listLike.addListLike(service);
            redirectAttributes.addFlashAttribute("message", "Add successfully");
        }
        return "redirect:/services2";
    }

    @GetMapping("listLike-remove/{id}")
    public String removeListLike(@PathVariable("id") Long id, @ModelAttribute("listLike") ListLike listLike, RedirectAttributes redirectAttributes) {
        List<Service> services = listLike.getServiceList();
        for (Service service1 : services) {
            if (service1.getId() == id) {
                listLike.removeFromListLike(id);
                redirectAttributes.addFlashAttribute("message", "Remove successfully");
                return "redirect:/services2";
            }
        }
        redirectAttributes.addFlashAttribute("message", "Please like this service first");
        return "redirect:/services2";
    }
    @GetMapping("listLike-remove2/{id}")
    public ModelAndView removeListLike2(@PathVariable("id") Long id, @ModelAttribute("listLike") ListLike listLike) {
        List<Service> services = listLike.getServiceList();
        for (Service service1 : services) {
            if (service1.getId() == id) {
                listLike.removeFromListLike(id);
                return new ModelAndView("listLike","message","Remove successfully");
            }
        }
        return new ModelAndView("listLike","message","Not fault");
    }

    @GetMapping("/services2")
    public ModelAndView listService(Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        return new ModelAndView("service/listService", "services", services);
    }
}
