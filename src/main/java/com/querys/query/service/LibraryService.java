package com.querys.query.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querys.query.model.Author;
import com.querys.query.model.Book;
import com.querys.query.model.Review;
import com.querys.query.repository.AuthorRepository;
import com.querys.query.repository.BookRepository;
import com.querys.query.repository.ReviewRepository;

import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;

    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
    }

    // JPQL Query 1 (No parameters): Find all books
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooksJpql();
    }

    // JPQL Query 2 (No parameters): Find all authors
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorRepository.findAllAuthorsJpql();
    }

    // JPQL Query 3 (With parameters): Find books by publisher name
    @Transactional(readOnly = true)
    public List<Book> findBooksByPublisherName(String publisherName) {
        return bookRepository.findByPublisherName(publisherName);
    }

    // JPQL Query 4 (With parameters): Find authors by a specific genre of their books
    @Transactional(readOnly = true)
    public List<Author> findAuthorsByGenre(String genreName) {
        return authorRepository.findAuthorsByGenreName(genreName);
    }

    // JPQL Query 5 (With parameters): Find reviews for a specific book title
    @Transactional(readOnly = true)
    public List<Review> findReviewsByBookTitle(String bookTitle) {
        return reviewRepository.findReviewsByBookTitle(bookTitle);
    }
}