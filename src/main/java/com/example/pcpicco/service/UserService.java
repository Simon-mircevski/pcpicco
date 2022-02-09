package com.example.pcpicco.service;

import com.example.pcpicco.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> register(String name, String surname, String email, String password, String repeatpassword);
    User login(String email, String password);
}
