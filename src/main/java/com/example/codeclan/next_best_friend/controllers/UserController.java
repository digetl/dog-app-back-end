package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String home() {
        System.out.println("REQUEST / ROUTE >>>>>");
        return "Welcome Please login";
    }

    @PostMapping(value = "/login/")
    public ResponseEntity<Optional<User>> loginUser(@RequestBody User user) {
        System.out.println("REQUEST POST /login ROUTE >>>>>");
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (!foundUser.isPresent()){
            return new ResponseEntity<>(foundUser, HttpStatus.BAD_GATEWAY);
        }
        System.out.println("USER FOUND");
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent()){
            return new ResponseEntity("That Username Already Exists", HttpStatus.BAD_REQUEST);
        }
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return new ResponseEntity("Reg Success", HttpStatus.OK);
    }



}
