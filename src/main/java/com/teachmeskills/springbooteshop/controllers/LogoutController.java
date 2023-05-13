package com.teachmeskills.springbooteshop.controllers;

import static com.teachmeskills.springbooteshop.constants.Constant.SIGN_IN_PAGE;

import com.teachmeskills.springbooteshop.entities.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping()
    public ModelAndView openLogOutPage(@SessionAttribute("user") User user) {
        ModelMap model = new ModelMap();
        model.addAttribute("user", user);
        return new ModelAndView(SIGN_IN_PAGE,model);
    }
}
