package com.querys.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querys.query.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JPQL Query with parameter: Find books by publisher name
    @Query("SELECT b FROM Book b JOIN b.publisher p WHERE p.name = :publisherName")
    List<Book> findByPublisherName(String publisherName);

    // JPQL Query without parameter: Find all books
    @Query("SELECT b FROM Book b")
    List<Book> findAllBooksJpql();
}
