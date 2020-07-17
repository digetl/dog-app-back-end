package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.Dog;
import com.example.codeclan.next_best_friend.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @GetMapping(value = "/dogs")
    public ResponseEntity getDogs() {
        return new ResponseEntity(dogRepository.findAll(), HttpStatus.OK);
    }

}

