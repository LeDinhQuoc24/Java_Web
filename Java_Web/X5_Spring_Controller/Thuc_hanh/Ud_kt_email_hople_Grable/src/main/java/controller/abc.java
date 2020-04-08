package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class abc {
    @GetMapping("/abc")
    public String hello() {
        System.out.println("Hello");
        return "index";
    }
}
