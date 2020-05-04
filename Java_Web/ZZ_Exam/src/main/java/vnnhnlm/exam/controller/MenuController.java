package vnnhnlm.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @GetMapping("menu")
    public ModelAndView menu() {
        return new ModelAndView("menu/menu");
    }
    @GetMapping("readme")
    public ModelAndView readme() {
        return new ModelAndView("menu/readme");
    }

    @GetMapping("search")
    public ModelAndView search() {
        return new ModelAndView("menu/search");
    }

}
