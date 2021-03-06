package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting1")
    public String greeting(@RequestParam String name, Model modle){
        modle.addAttribute("name", name);
        return "index1";
    }
    //Chạy câu lệnh kiểm tra:
    //http://localhost:8080/greeting1?name=Lam
    @GetMapping("/greeting2")
    public String greeting(){
        return "index2";
    }
    @GetMapping("/greeting3")
    public String getIndex(Model model){
        model.addAttribute("hello","Greeting hello class");
        return "index3";
    }
}
