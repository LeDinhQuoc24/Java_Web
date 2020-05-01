package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Position;
import casestudy.javaweb.persistence.entity.RentType;
import casestudy.javaweb.persistence.service.RentTypeService;
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
public class RentTypeController {
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("rentTypes")
    public ModelAndView listRentType() {
        List<RentType> rentTypes = rentTypeService.findAll();
        return new ModelAndView("rentType/listRentType", "rentTypes",rentTypes);
    }

    @GetMapping("createRentType")
    public ModelAndView showFormCreate() {
        return new ModelAndView("rentType/createRentType", "rentType", new RentType());
    }

    @PostMapping("createRentType")
    public ModelAndView saveRentType(@ModelAttribute("rentType") RentType rentType) {
        rentTypeService.save(rentType);
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("rentType/listRentType");
        modelAndView.addObject("message", "New RentType created successfully");
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @GetMapping("editRentType/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        RentType rentType = rentTypeService.findById(id);
        if (rentType != null) {
            return new ModelAndView("rentType/editRentType", "rentType", rentType);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editRentType")
    public ModelAndView updateRentType(@ModelAttribute("rentType")RentType rentType) {
        rentTypeService.save(rentType);
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("rentType/listRentType");
        modelAndView.addObject("message", "RentType updated successfully");
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @GetMapping("deleteRentType/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        RentType rentType = rentTypeService.findById(id);
        if (rentType != null) {
            return new ModelAndView("rentType/deleteRentType", "rentType", rentType);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deleteRentType")
    public String deleteRentType(@ModelAttribute("rentType")RentType rentType, RedirectAttributes redirectAttributes) {
        rentTypeService.remove(rentType.getId());
        redirectAttributes.addFlashAttribute("message","RentType deleted successfully");
        return "redirect:rentTypes";
    }
    @GetMapping("deleteAllRentTypes")
    public String deleteAllRentTypes(RedirectAttributes redirectAttributes) {
        for (RentType rentType : rentTypeService.findAll()) {
            rentTypeService.remove(rentType.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All rentTypes deleted successfully");
        return "redirect:rentTypes";
    }
}
