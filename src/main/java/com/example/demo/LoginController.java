package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login_moveLogin")
    public String moveLogin() {
        return "login/login";
    }
}
