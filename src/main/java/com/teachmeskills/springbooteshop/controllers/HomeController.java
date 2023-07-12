package com.teachmeskills.springbooteshop.controllers;

import com.teachmeskills.springbooteshop.dto.CategoryDto;
import com.teachmeskills.springbooteshop.security.CustomUserDetails;
import com.teachmeskills.springbooteshop.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.teachmeskills.springbooteshop.utils.Constant.HOME_PAGE;

@Setter
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView openHomePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        log.info("User with email: " + principal.getUser().getEmail() +  "successfully logged in!");
        ModelMap model = new ModelMap();
        List<CategoryDto> categoriesList = categoryService.getCategories();
        model.addAttribute("categories", categoriesList);
        return new ModelAndView(HOME_PAGE, model);
    }
}
