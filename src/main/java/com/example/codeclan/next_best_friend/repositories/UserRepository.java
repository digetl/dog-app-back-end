package com.example.codeclan.next_best_friend.repositories;

import com.example.codeclan.next_best_friend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
