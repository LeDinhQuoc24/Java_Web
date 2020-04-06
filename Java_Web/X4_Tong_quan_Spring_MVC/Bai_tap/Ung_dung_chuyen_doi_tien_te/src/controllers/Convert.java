package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Convert {
    @PostMapping("/convert")
    public String convert (@RequestParam String usd,@RequestParam String rate, Model model){
        float rate1 = Float.parseFloat(rate);
        float usd1 = Float.parseFloat(usd);
        float vnd = rate1 * usd1;
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", vnd);
        return "index1";
    }
}
