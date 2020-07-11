package com.example.codeclan.next_best_friend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "breeders")
public class Breeder extends User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "breederNumbers")
    private String breederNumber;

    @Column(name = "roles")
    private String roles;

//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "breeder", fetch = FetchType.LAZY)
    private List<Listing> listings;

    public Breeder(String username, String password, String breederNumber) {
        super(username, password);
        this.breederNumber = breederNumber;
//        this.listings = new ArrayList<>();
        this.roles = "ROLE_BREEDER";

    }

    public Breeder() {
    }

    public String getBreederNumber() {
        return breederNumber;
    }

    public void setBreederNumber(String breederNumber) {
        this.breederNumber = breederNumber;
    }

    @Override
    public String getRoles() {
        return roles;
    }

    @Override
    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public List<Listing> getListings() {
        return listings;
    }

    @Override
    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}
