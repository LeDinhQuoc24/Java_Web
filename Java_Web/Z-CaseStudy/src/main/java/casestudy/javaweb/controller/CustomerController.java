package casestudy.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @GetMapping("/menu")
    public ModelAndView modelAndView() {
        return new ModelAndView("show/menu");
    }
}
