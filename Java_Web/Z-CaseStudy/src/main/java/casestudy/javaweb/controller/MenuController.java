package casestudy.javaweb.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

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


}
