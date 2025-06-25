package com.querys.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querys.query.model.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // JPQL Query with parameter: Find reviews for a specific book title
    @Query("SELECT r FROM Review r JOIN r.book b WHERE b.title = :bookTitle")
    List<Review> findReviewsByBookTitle(String bookTitle);
}