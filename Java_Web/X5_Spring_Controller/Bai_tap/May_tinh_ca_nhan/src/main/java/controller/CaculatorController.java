
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class CaculatorController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        return "index";
    }

    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String save(@RequestParam("number_one") Float first_number,@RequestParam("number_two") Float second_number,@RequestParam("operator") Character opera,Model model){
        try{
            Float kq=Calculator.calculator(first_number,second_number,opera);
            model.addAttribute("result",kq);
        }catch (Exception ex){
            String error=ex.getMessage();
            model.addAttribute("error",error);
        }


        return "index";
    }
}