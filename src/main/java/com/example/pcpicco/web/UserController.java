package com.example.pcpicco.web;

import com.example.pcpicco.model.Product;
import com.example.pcpicco.model.User;
import com.example.pcpicco.model.enumeration.Roles;
import com.example.pcpicco.repository.ProductRepository;
import com.example.pcpicco.repository.UserRepository;
import com.example.pcpicco.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final ProductRepository productRepository;

    public UserController(UserRepository userRepository, UserService userService, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.productRepository = productRepository;
    }


    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

}
