package com.example.codeclan.next_best_friend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private int height;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Listing(String name, int height, int age, Dog dog, User user) {
        this.name = name;
        this.height = height;
        this.age = age;
        this.dog = dog;
        this.user = user;
    }

    public Listing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public User getBreeder() {
        return user;
    }

    public void setBreeder(Breeder breeder) {
        this.user = breeder;
    }

}
