package com.querys.query.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querys.query.model.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // JPQL Query with parameter: Find authors who have written books in a specific genre
    @Query("SELECT DISTINCT a FROM Author a JOIN a.books b JOIN b.genre g WHERE g.name = :genreName")
    List<Author> findAuthorsByGenreName(String genreName);

    // JPQL Query without parameter: Find all authors
    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthorsJpql();
}