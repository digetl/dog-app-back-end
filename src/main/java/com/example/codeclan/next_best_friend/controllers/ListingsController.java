package com.example.codeclan.next_best_friend.controllers;

import com.example.codeclan.next_best_friend.models.Breeder;
import com.example.codeclan.next_best_friend.models.Listing;
import com.example.codeclan.next_best_friend.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "localhost:3000")
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

    @DeleteMapping(value = "/listings/{id}")
    public ResponseEntity deleteBreederListings(@PathVariable Long id){
        listingRepository.deleteById(id);
        return new ResponseEntity("Listing Deleted " + id, HttpStatus.OK);
    }

    @PutMapping(value = "/listings/{id}")
    public ResponseEntity<Listing> putListing(@RequestBody Listing listing, @PathVariable Long id){
        Listing listingToUpdate = listingRepository.findById(id).get();
        listingToUpdate.setAge(listing.getAge());
        listingToUpdate.setBreeder((Breeder) listing.getBreeder());
        listingToUpdate.setDog(listing.getDog());
        listingToUpdate.setName(listing.getName());
        listingToUpdate.setHeight(listing.getHeight());
        listingRepository.save(listingToUpdate);
        return new ResponseEntity<>(listingToUpdate, HttpStatus.OK);
    }
}
