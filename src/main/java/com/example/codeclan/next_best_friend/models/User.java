package com.example.codeclan.next_best_friend.models;

import org.hibernate.annotations.Polymorphism;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usernames")
    private String username;

    @Column(name = "passwords")
    private String password;

    @Column
    private String roles;

//    @OneToOne(mappedBy = "user")
//    private Breeder breeder;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Listing> listings;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = "ROLE_USER";
        this.listings = new ArrayList<>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String role) {
        this.roles = role;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}