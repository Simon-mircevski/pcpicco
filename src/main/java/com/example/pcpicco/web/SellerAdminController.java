package com.example.pcpicco.web;

import com.example.pcpicco.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/add/sellerAdmin")
public class SellerAdminController {
    private final UserService userService;

    public SellerAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getPage(){
        return "addSellerAdmin";
    }
    @PostMapping()
    public String addSellerAdmin(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String repeatPassword){
        this.userService.addSellerAdmin(email,password,repeatPassword);
        return "redirect:/products";
    }
}
