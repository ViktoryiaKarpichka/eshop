package com.teachmeskills.springbooteshop.controllers;

import com.teachmeskills.springbooteshop.entities.User;
import com.teachmeskills.springbooteshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.teachmeskills.springbooteshop.utils.Constant.REGISTRATION_PAGE;
import static com.teachmeskills.springbooteshop.utils.Constant.SIGN_IN_PAGE;

@RequiredArgsConstructor
@RestController
@SessionAttributes({"user"})
@RequestMapping("/login")
public class AuthController {

    private final UserService userService;

    @GetMapping
    public ModelAndView openLoginPage() {
        return new ModelAndView(SIGN_IN_PAGE);
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }
    @GetMapping("/registration")
    public ModelAndView registrationPage(@ModelAttribute("user") User user) {
        return new ModelAndView(REGISTRATION_PAGE);
    }

  /*  @PostMapping("/registration")
    public ModelAndView performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, ModelAndView modelAndView) throws AuthorizationException {
        //userValidatorRegistration.validate(user, bindingResult);
       // userService.authenticate(user);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(REGISTRATION_PAGE);
        } else {
            boolean registrationSuccess = userService.registrationNewUser(userMapper.convertToUser(user));
            if (registrationSuccess) {
                modelAndView.addObject(SUCCESS_REGISTRATION, true);
            } else {
                modelAndView.addObject(ERROR_REGISTRATION, true);
            }
        }
        return modelAndView;
    }*/
}
