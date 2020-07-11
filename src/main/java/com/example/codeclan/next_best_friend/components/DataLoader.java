package com.example.codeclan.next_best_friend.components;

import com.example.codeclan.next_best_friend.models.Breeder;
import com.example.codeclan.next_best_friend.models.Dog;
import com.example.codeclan.next_best_friend.models.Listing;
import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.repositories.BreederRepository;
import com.example.codeclan.next_best_friend.repositories.DogRepository;
import com.example.codeclan.next_best_friend.repositories.ListingRepository;
import com.example.codeclan.next_best_friend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BreederRepository breederRepository;

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DogRepository dogRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        String password1 = passwordEncoder.encode("passw");
        String password2 = passwordEncoder.encode("breed");

        User user = new User("Jay", password1);
        userRepository.save(user);

        Breeder breeder1 = new Breeder("Dave", password2, "101");
        breederRepository.save(breeder1);

        Dog border = new Dog("Border Terrier", "Medium", "Terrier");
        dogRepository.save(border);
        Dog alsatian = new Dog("German Sheppard", "Large", "Working Dog");
        dogRepository.save(alsatian);
//
        Listing listing1 = new Listing("Larry", 120, 2, alsatian, breeder1);
        listingRepository.save(listing1);

        Listing listing2 = new Listing("Wuffle", 30, 1, border, breeder1);
        listingRepository.save(listing2);

    }

}
