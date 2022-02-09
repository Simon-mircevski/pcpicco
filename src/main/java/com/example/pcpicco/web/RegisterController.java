package com.example.pcpicco.web;

import com.example.pcpicco.model.User;
import com.example.pcpicco.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerPage(){
        return "register";
    }

    @PostMapping()
    public String register(@RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String repeatPassword){
        this.userService.register(name,surname,email,password,repeatPassword);
        return "redirect:/login";
    }
}
