package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
//    @GetMapping("/greeting")
//    public String greeting(){
//        return "index1";
//    }
    @GetMapping("/greeting")
    public String getIndex(Model model){
        model.addAttribute("hello","Greeting hello class");
        return "index1";
    }
}
