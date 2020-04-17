package vnnhnlm.count_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.count_view.model.Count;

@Controller
@SessionAttributes
public class CountController {
    /* add MyCounter in model attribute */
    @ModelAttribute("Count")
    public Count setNewCount() {
        return new Count();
    }

    @GetMapping
    public ModelAndView get(@ModelAttribute("Count") Count count) {
        ModelAndView modelAndView=new ModelAndView("views");
        modelAndView.addObject("count", count);
        return modelAndView;
    }
}
