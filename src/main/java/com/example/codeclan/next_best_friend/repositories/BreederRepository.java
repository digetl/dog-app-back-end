package com.example.codeclan.next_best_friend.repositories;

import com.example.codeclan.next_best_friend.models.Breeder;
import com.example.codeclan.next_best_friend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreederRepository extends JpaRepository<Breeder, Long> {
    Optional<Breeder> findByUsername(String username);

    Boolean findByBreederNumberNotNull();
}
