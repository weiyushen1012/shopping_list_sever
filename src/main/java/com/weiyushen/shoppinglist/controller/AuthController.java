package com.weiyushen.shoppinglist.controller;

import com.weiyushen.shoppinglist.model.User;
import com.weiyushen.shoppinglist.model.UserBody;
import com.weiyushen.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("error")
    public String getErrorPage() {
        return "error";
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("signup")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("signup")
    public String userSignup(Model model, @ModelAttribute("user") UserBody body) {

        var existingUser = userRepository.getUserByEmail(body.getEmail());

        if (existingUser != null) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", "Email " + body.getEmail() + " already exists.");
            return "signup";
        }

        if (body.getPassword().length() < 8) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", "Password is too short.");
            return "signup";
        }

        if (!body.getPassword().equals(body.getConfirmPassword())) {
            model.addAttribute("hasError", true);
            model.addAttribute("errorMessage", "Password and confirm password does not match.");
            return "signup";
        }

        User newUser = new User();
        newUser.setEmail(body.getEmail());
        newUser.setPassword(body.getPassword());
        newUser.setRole("ROLE_USER");
        newUser.setEnabled(true);

        var currentDate = new Date();

        newUser.setCreated(currentDate);
        newUser.setUpdated(currentDate);

        userRepository.save(newUser);

        return "redirect:/";


    }
}
