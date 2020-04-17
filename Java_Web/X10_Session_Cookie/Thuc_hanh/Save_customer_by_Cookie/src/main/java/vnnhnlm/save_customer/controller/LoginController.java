package vnnhnlm.save_customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.save_customer.model.Customer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("customer")
public class LoginController {

    /*add user in model attribute*/
    @ModelAttribute("customer")
    public Customer setUpCustomerForm() {
        return new Customer();
    }

    @RequestMapping("/login")
    public ModelAndView Login(@CookieValue(value = "setCustomer", defaultValue = "") String setCustomer) {
        Cookie cookie = new Cookie("setCustomer", setCustomer);
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("cookieValue", cookie);
        return modelAndView;
    }

    @PostMapping("/dologin")
    public ModelAndView doLogin(@ModelAttribute("customer")Customer customer,
                                @CookieValue(value="setCustomer", defaultValue = "") String setCustomer,
                                HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("login");
        //implement business logic
        if (customer.getEmail().equals("vnnhnlm@gmail.com") && customer.getPassword().equals("vnnhnlm")) {
            if (customer.getEmail() != null)
                setCustomer = customer.getEmail();
                // create cookie and set it in response
                Cookie cookie = new Cookie("setCustomer", setCustomer);
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
                //get all cookies
                Cookie[] cookies = request.getCookies();
                //iterate each cookie
                for (Cookie ck : cookies) {
                    //display only the cookie with the name 'setUser'
                    if (ck.getName().equals("setCustomer")) {
                        modelAndView.addObject("cookieValue", ck);
                        break;
                    } else {
                        ck.setValue("");
                        modelAndView.addObject("cookieValue", ck);
                        break;
                    }
                }
                modelAndView.addObject("message", "Login success. Welcome ");
            } else {
                customer.setEmail("");
                Cookie cookie = new Cookie("setCustomer", setCustomer);
                modelAndView.addObject("cookieValue", cookie);
                modelAndView.addObject("message", "Login failed. Try again.");
            }
        return modelAndView;
    }
}
