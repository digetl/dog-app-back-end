package com.example.codeclan.next_best_friend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "breed")
    private String breed;

    @Column(name = "size")
    private String size;

    @Column(name = "family")
    private String family;

    @JsonBackReference
    @OneToMany(mappedBy = "dog")
    private List<Listing> listing;

    public Dog(String breed, String size, String family) {
        this.breed = breed;
        this.size = size;
        this.family = family;
        this.listing = new ArrayList<>();
    }

    public Dog() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGroup() {
        return family;
    }

    public void setGroup(String group) {
        this.family = group;
    }


    public List<Listing> getListing() {
        return listing;
    }

    public void setListing(List<Listing> listing) {
        this.listing = listing;
    }
}
