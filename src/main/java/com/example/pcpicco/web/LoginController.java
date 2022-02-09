package com.example.pcpicco.web;

import com.example.pcpicco.model.User;
import com.example.pcpicco.model.exceptions.InvalidUserException;
import com.example.pcpicco.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest req){
        User user = null;
        try{
            user = this.userService.login(email,password);
            req.getSession().setAttribute("user",user);
            return "redirect:/products";
        }
        catch(InvalidUserException exception){
            model.addAttribute("hasErrors", true);
            model.addAttribute("error",exception.getMessage());
            return "login";
        }
    }
}
