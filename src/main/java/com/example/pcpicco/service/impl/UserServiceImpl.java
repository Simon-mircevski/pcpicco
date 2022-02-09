package com.example.pcpicco.service.impl;

import com.example.pcpicco.model.User;
import com.example.pcpicco.model.enumeration.Roles;
import com.example.pcpicco.model.exceptions.EmailAlreadyExistsException;
import com.example.pcpicco.model.exceptions.InvalidUserException;
import com.example.pcpicco.model.exceptions.PasswordsDontMatchException;
import com.example.pcpicco.repository.UserRepository;
import com.example.pcpicco.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> register(String name, String surname, String email, String password, String repeatpassword) {
        if(email.isEmpty() || email == null || password.isEmpty() || password == null){
            throw new IllegalArgumentException();
        }
        if(userRepository.findByEmail(email)!=null){
            throw new EmailAlreadyExistsException();
        }
        if(!password.equals(repeatpassword)){
            throw new PasswordsDontMatchException();
        }
        User user = new User(email,password, Roles.CLIENT);
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email,password);
        if(user==null){
            throw new InvalidUserException();
        }
        return user;
    }
}
