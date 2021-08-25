package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private final UserService userService;

    @PostMapping
    public String signupUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        String signupError = null;
        if (!userService.isUsernameAvailable(user.getUsername())) {
            signupError = "User already exists";
        }
        if (signupError == null) {
            int rowAdded = userService.createUser(user);
            if (rowAdded < 0) {
                signupError = "An Error occurred, please try again!";
            }
            if (signupError == null) {
                redirectAttributes.addFlashAttribute("signupSuccess", true);
                redirectAttributes.addFlashAttribute("successMessage", "Account have been created. Please login to continue");
                return "redirect:/login";
            }
        }

        return "redirect:/signup";
    }

    @GetMapping
    public String signupView() {
        return "signup";
    }

    public SignupController(UserService userService) {
        this.userService = userService;
    }

}
