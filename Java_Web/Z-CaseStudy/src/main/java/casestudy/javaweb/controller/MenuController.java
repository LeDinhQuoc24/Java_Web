package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.ListLike;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("listLike")
@Controller
public class MenuController {

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
    public ModelAndView addListLike(@PathVariable("id")Long id) {
        return new ModelAndView();
    }

    @GetMapping("listLike-remove/{id}")
    public ModelAndView removeListLike(@PathVariable("id")Long id) {
        return new ModelAndView();
    }

}
