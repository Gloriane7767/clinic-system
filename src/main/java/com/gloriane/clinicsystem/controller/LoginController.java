package com.gloriane.clinicsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Loads login.html
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";  // Redirect root URL to dashboard
    }
}
