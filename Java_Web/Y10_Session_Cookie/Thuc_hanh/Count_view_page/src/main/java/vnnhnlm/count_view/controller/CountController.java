package vnnhnlm.count_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.count_view.model.Count;

@Controller
@SessionAttributes("count")
public class CountController {
    /* add MyCounter in model attribute */
    @ModelAttribute("count")
    public Count setNewCount() {
        return new Count();
    }

//    @GetMapping("/count")
//    public ModelAndView get(@ModelAttribute("count") Count count) {
//        ModelAndView modelAndView=new ModelAndView("views");
//        modelAndView.addObject("count", count.increment());
//        return modelAndView;
//    }
    @GetMapping("/")
    public String get2(@ModelAttribute("count") Count count) {
        count.increment();
        return "index";
    }
}

