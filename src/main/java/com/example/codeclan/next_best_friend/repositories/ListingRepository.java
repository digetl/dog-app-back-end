package com.example.codeclan.next_best_friend.repositories;

import com.example.codeclan.next_best_friend.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findAllByUserId(Long id);

}
