//package controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Controller
//public class EmailController {
//
//    private static Pattern pattern;
//    private Matcher matcher;
//
//    /* Khai báo Regex */
//    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
//
//    public EmailController() {
//        pattern = Pattern.compile(EMAIL_REGEX);
//    }
//
//
//    @GetMapping("/")
//    String getIndex() {
//        System.out.println("Hello");
//        return "index";
//    }
//
//    @PostMapping("/validate")
//    String validateEmail(@RequestParam("email") String email, Model model) {
//        boolean isvalid = this.validate(email);
//        if (!isvalid) {
//            model.addAttribute("message", "Email is invalid");
//            return "index";
//        }
//
//        model.addAttribute("email", email);
//        return "success";
//    }
//
//    private boolean validate(String regex) {
//        matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }
//
//}
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;

    /* Khai báo Regex */
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @PostMapping("/validate")
    public ModelAndView validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("email", email);
            return new ModelAndView("index", "message", "Email is valid");
        } else {
            return new ModelAndView("success", "email", email);
        }
    }

    public boolean validate(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
