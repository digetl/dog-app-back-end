package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.Breeder;
import com.example.codeclan.next_best_friend.models.Listing;
import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.repositories.BreederRepository;
import com.example.codeclan.next_best_friend.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BreederController {

    @Autowired
    BreederRepository breederRepository;

    @Autowired
    ListingRepository listingRepository;

    @GetMapping(value = "/breeders")
    public ResponseEntity<List<Breeder>> getBreeders(){
        return new ResponseEntity<>(breederRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/breeders/{id}")
    public ResponseEntity getBreeder(@PathVariable Long id){
        return new ResponseEntity(breederRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/breeders/{id}/listings")
    public ResponseEntity<List<Listing>> getBreederListings(@PathVariable Long id){
        return new ResponseEntity<>(listingRepository.findAllByUserId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/breeders/{id}/listings")
    public ResponseEntity<List<Listing>> postBreederListings(@PathVariable Long id){
        return new ResponseEntity<>(listingRepository.findAllByUserId(id), HttpStatus.OK);
    }



}
