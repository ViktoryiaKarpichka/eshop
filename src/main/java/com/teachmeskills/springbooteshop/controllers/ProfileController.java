package com.teachmeskills.springbooteshop.controllers;

import static com.teachmeskills.springbooteshop.utils.Constant.PROFILE_PAGE;

import com.teachmeskills.springbooteshop.entities.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public ModelAndView openProfilePage(@SessionAttribute("user") User user) {
        ModelMap model = new ModelMap();
        model.addAttribute("user", user);
        return new ModelAndView(PROFILE_PAGE, model);
    }
}
