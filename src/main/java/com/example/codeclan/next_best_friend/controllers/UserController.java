package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.Breeder;
import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.repositories.BreederRepository;
import com.example.codeclan.next_best_friend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BreederRepository breederRepository;

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

    @PostMapping(value = "/register/user")
    public ResponseEntity registerUser(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent()){
            return new ResponseEntity("That Username Already Exists", HttpStatus.BAD_REQUEST);
        }

        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return new ResponseEntity("Reg Success", HttpStatus.OK);

    }

    @PostMapping(value = "/register/breeder")
    public ResponseEntity registerBreeder(@RequestBody Breeder breeder){
        Optional<User> foundUser = userRepository.findByUsername(breeder.getUsername());
        Optional<Breeder> foundBreeder = breederRepository.findByUsername(breeder.getUsername());
        System.out.println(breeder);
        if (foundUser.isPresent()){
            return new ResponseEntity("That Username Already Exists", HttpStatus.BAD_REQUEST);
        }

        if (breeder.getBreederNumber() == null) {
            return new ResponseEntity("Please Enter Breeder Number", HttpStatus.BAD_REQUEST);
        }
        String password = passwordEncoder.encode(breeder.getPassword());
        breeder.setPassword(password);
        breeder.setRoles("ROLE_BREEDER");
        breederRepository.save(breeder);
        return new ResponseEntity("Welcome Breeder", HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        if (!userRepository.findById(id).isPresent()){
            return new ResponseEntity("User Id Not Found", HttpStatus.BAD_REQUEST);
        }
        userRepository.deleteById(id);
        return new ResponseEntity("User Deleted", HttpStatus.OK);
    }

}
