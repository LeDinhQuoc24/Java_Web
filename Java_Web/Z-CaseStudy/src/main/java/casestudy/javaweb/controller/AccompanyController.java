package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Accompany;
import casestudy.javaweb.persistence.service.AccompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccompanyController {
    @Autowired
    private AccompanyService accompanyService;

    @GetMapping("accompanys")
    public ModelAndView listAccompany() {
        List<Accompany> accompanys = accompanyService.findAll();
        return new ModelAndView("accompany/listAccompany", "accompanys", accompanys);
    }

    @GetMapping("createAccompany")
    public ModelAndView showFormCreate() {
        return new ModelAndView("accompany/createAccompany", "accompany", new Accompany());
    }

    @PostMapping("createAccompany")
    public ModelAndView saveAccompany(@ModelAttribute("accompany") Accompany accompany) {
        accompanyService.save(accompany);
        List<Accompany> accompanys = accompanyService.findAll();
        ModelAndView modelAndView = new ModelAndView("accompany/listAccompany");
        modelAndView.addObject("message", "New Accompany created successfully");
        modelAndView.addObject("accompanys", accompanys);
        return modelAndView;
    }

    @GetMapping("editAccompany/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Accompany accompany = accompanyService.findById(id);
        if (accompany != null) {
            return new ModelAndView("accompany/editAccompany", "accompany", accompany);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editAccompany")
    public ModelAndView updateAccompany(@ModelAttribute("accompany") Accompany accompany) {
        accompanyService.save(accompany);
        List<Accompany> accompanys = accompanyService.findAll();
        ModelAndView modelAndView = new ModelAndView("accompany/listAccompany");
        modelAndView.addObject("message", "Accompany updated successfully");
        modelAndView.addObject("accompanys", accompanys);
        return modelAndView;
    }

    @GetMapping("deleteAccompany/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Accompany accompany = accompanyService.findById(id);
        if (accompany != null) {
            return new ModelAndView("accompany/deleteAccompany", "accompany", accompany);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deleteAccompany")
    public String deleteAccompany(@ModelAttribute("accompany")Accompany accompany) {
        accompanyService.remove(accompany.getId());
        return "redirect:accompanys";
    }
}
