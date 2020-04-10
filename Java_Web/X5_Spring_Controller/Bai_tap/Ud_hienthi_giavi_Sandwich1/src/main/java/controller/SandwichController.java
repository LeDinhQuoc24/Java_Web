package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class SandwichController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "index";
    }

    @RequestMapping(value = "/choose", method = RequestMethod.POST)
    public String save(@RequestParam("sandwich") String condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "sandwich";
    }
}