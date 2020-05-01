package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Customer;
import casestudy.javaweb.persistence.entity.Degree;
import casestudy.javaweb.persistence.service.DegreeService;
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
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    @GetMapping("degrees")
    public ModelAndView listDegree() {
        List<Degree> degrees = degreeService.findAll();
        return new ModelAndView("degree/listDegree", "degrees", degrees);
    }

    @GetMapping("createDegree")
    public ModelAndView showFormCreate() {
        return new ModelAndView("degree/createDegree", "degree", new Degree());
    }

    @PostMapping("createDegree")
    public ModelAndView saveDegree(@ModelAttribute("degree") Degree degree) {
        degreeService.save(degree);
        List<Degree> degrees = degreeService.findAll();
        ModelAndView modelAndView = new ModelAndView("degree/listDegree");
        modelAndView.addObject("message", "New Degree created successfully");
        modelAndView.addObject("degrees", degrees);
        return modelAndView;
    }

    @GetMapping("editDegree/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Degree degree = degreeService.findById(id);
        if (degree != null) {
            return new ModelAndView("degree/editDegree", "degree", degree);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editDegree")
    public ModelAndView updateDegree(@ModelAttribute("degree") Degree degree) {
        degreeService.save(degree);
        List<Degree> degrees = degreeService.findAll();
        ModelAndView modelAndView = new ModelAndView("degree/listDegree");
        modelAndView.addObject("message", "Degree updated successfully");
        modelAndView.addObject("degrees", degrees);
        return modelAndView;
    }

    @GetMapping("deleteDegree/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Degree degree = degreeService.findById(id);
        if (degree != null) {
            return new ModelAndView("degree/deleteDegree", "degree", degree);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deleteDegree")
    public String deleteDegree(@ModelAttribute("degree")Degree degree, RedirectAttributes redirectAttributes) {
        degreeService.remove(degree.getId());
        redirectAttributes.addFlashAttribute("message","Degree deleted successfully");
        return "redirect:degrees";
    }
    @GetMapping("deleteAllDegrees")
    public String deleteAllDegrees(RedirectAttributes redirectAttributes) {
        for (Degree degree : degreeService.findAll()) {
            degreeService.remove(degree.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All degrees deleted successfully");
        return "redirect:degrees";
    }
}
