package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.entity.Part;
import casestudy.javaweb.persistence.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class PartController {
    @Autowired
    private PartService partService;

    @GetMapping("parts")
    public ModelAndView listPart() {
        List<Part> parts = partService.findAll();
        return new ModelAndView("part/listPart", "parts",parts);
    }

    @GetMapping("createPart")
    public ModelAndView showFormCreate() {
        return new ModelAndView("part/createPart", "part", new Part());
    }

    @PostMapping("createPart")
    public ModelAndView savePart(@ModelAttribute("part") Part part) {
        partService.save(part);
        List<Part> parts = partService.findAll();
        ModelAndView modelAndView = new ModelAndView("part/listPart");
        modelAndView.addObject("message", "New Part created successfully");
        modelAndView.addObject("parts", parts);
        return modelAndView;
    }

    @GetMapping("editPart/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Part part = partService.findById(id);
        if (part != null) {
            return new ModelAndView("part/editPart", "part", part);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editPart")
    public ModelAndView updatePart(@ModelAttribute("part") Part part) {
        partService.save(part);
        List<Part> parts = partService.findAll();
        ModelAndView modelAndView = new ModelAndView("part/listPart");
        modelAndView.addObject("message", "Part updated successfully");
        modelAndView.addObject("parts", parts);
        return modelAndView;
    }

    @GetMapping("deletePart/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Part part = partService.findById(id);
        if (part != null) {
            return new ModelAndView("part/deletePart", "part", part);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deletePart")
    public String deletePart(@ModelAttribute("part")Part part, RedirectAttributes redirectAttributes) {
        partService.remove(part.getId());
        redirectAttributes.addFlashAttribute("message","Part deleted successfully");
        return "redirect:parts";
    }
    @GetMapping("deleteAllParts")
    public String deleteAllParts(RedirectAttributes redirectAttributes) {
        for (Part part : partService.findAll()) {
            partService.remove(part.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All parts deleted successfully");
        return "redirect:parts";
    }
}
