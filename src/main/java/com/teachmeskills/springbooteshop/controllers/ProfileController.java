package com.teachmeskills.springbooteshop.controllers;

import static com.teachmeskills.springbooteshop.utils.Constant.PROFILE_PAGE;

import com.teachmeskills.springbooteshop.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public ModelAndView openProfilePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        ModelMap model = new ModelMap();
        model.addAttribute("user", principal.getUser());
        return new ModelAndView(PROFILE_PAGE, model);
    }
}
