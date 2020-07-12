package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.Listing;
import com.example.codeclan.next_best_friend.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingsController {

    @Autowired
    ListingRepository listingRepository;

    @GetMapping(value = "/listings")
    public ResponseEntity<List<Listing>> findAllListings(){
        return new ResponseEntity<>(listingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/listings/{id}")
    public ResponseEntity getListing(@PathVariable Long id){
        return new ResponseEntity(listingRepository.findById(id), HttpStatus.OK);
    }

}
