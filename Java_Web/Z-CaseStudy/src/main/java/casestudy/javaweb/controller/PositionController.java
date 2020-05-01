package casestudy.javaweb.controller;


import casestudy.javaweb.persistence.entity.Part;
import casestudy.javaweb.persistence.entity.Position;
import casestudy.javaweb.persistence.service.PositionService;
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
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("positions")
    public ModelAndView listPosition() {
        List<Position> positions = positionService.findAll();
        return new ModelAndView("position/listPosition", "positions",positions);
    }

    @GetMapping("createPosition")
    public ModelAndView showFormCreate() {
        return new ModelAndView("position/createPosition", "position", new Position());
    }

    @PostMapping("createPosition")
    public ModelAndView savePosition(@ModelAttribute("position") Position position) {
        positionService.save(position);
        List<Position> positions = positionService.findAll();
        ModelAndView modelAndView = new ModelAndView("position/listPosition");
        modelAndView.addObject("message", "New Position created successfully");
        modelAndView.addObject("positions", positions);
        return modelAndView;
    }

    @GetMapping("editPosition/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Position position = positionService.findById(id);
        if (position != null) {
            return new ModelAndView("position/editPosition", "position", position);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editPosition")
    public ModelAndView updatePosition(@ModelAttribute("position") Position position) {
        positionService.save(position);
        List<Position> positions = positionService.findAll();
        ModelAndView modelAndView = new ModelAndView("position/listPosition");
        modelAndView.addObject("message", "Position updated successfully");
        modelAndView.addObject("positions", positions);
        return modelAndView;
    }

    @GetMapping("deletePosition/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Position position = positionService.findById(id);
        if (position != null) {
            return new ModelAndView("position/deletePosition", "position", position);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deletePosition")
    public String deletePosition(@ModelAttribute("position")Position position, RedirectAttributes redirectAttributes) {
        positionService.remove(position.getId());
        redirectAttributes.addFlashAttribute("message","Position deleted successfully");
        return "redirect:positions";
    }
    @GetMapping("deleteAllPositions")
    public String deleteAllPositions(RedirectAttributes redirectAttributes) {
        for (Position position : positionService.findAll()) {
            positionService.remove(position.getId());
        }
        redirectAttributes.addFlashAttribute("message", "All positions deleted successfully");
        return "redirect:positions";
    }
}
