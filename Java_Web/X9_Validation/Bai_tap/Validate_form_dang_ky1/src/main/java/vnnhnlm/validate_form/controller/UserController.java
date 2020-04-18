package vnnhnlm.validate_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.validate_form.model.User;

import vnnhnlm.validate_form.service.UserService;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView listUsers( @PageableDefault(value = 5) Pageable pageable) {
        Page<User> users=userService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("create-user")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("create-user")
    public ModelAndView saveUser(@Validated @ModelAttribute("user")User user, Pageable pageable,BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/user/create");
        } else {
            userService.save(user);
            modelAndView = new ModelAndView("/user/list");
            Page<User> users=userService.findAll(pageable);
            modelAndView.addObject("users", users);
            modelAndView.addObject("message", "New user created successfully");
        }
        return modelAndView;
    }
}
