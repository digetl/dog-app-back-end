package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    public String home() {
        System.out.println("REQUEST / ROUTE >>>>>");
        return "Welcome Please login";}

//


    @PostMapping(value = "/login/")
    public ResponseEntity<Optional<User>> loginUser(@RequestBody User user) {
        System.out.println(user.getUsername());
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
//        System.out.println(userDetails);

        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
//        System.out.println(user.getUsername());

        if (!foundUser.isPresent()){
            return new ResponseEntity<>(foundUser, HttpStatus.BAD_GATEWAY);
        }

        System.out.println("REQUEST POST /user ROUTE >>>>>");
        System.out.println(foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }


}
