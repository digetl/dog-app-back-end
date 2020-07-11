package com.example.codeclan.next_best_friend.models;

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

//    public List<Listing> getListings() {
//        return listings;
//    }
//
//    public void setListings(List<Listing> listings) {
//        this.listings = listings;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
