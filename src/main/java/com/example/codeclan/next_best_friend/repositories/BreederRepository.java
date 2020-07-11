package com.example.codeclan.next_best_friend.repositories;

import com.example.codeclan.next_best_friend.models.Breeder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreederRepository extends JpaRepository<Breeder, Long> {
}
