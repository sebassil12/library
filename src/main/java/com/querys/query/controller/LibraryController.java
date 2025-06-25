package com.querys.query.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querys.query.model.Author;
import com.querys.query.model.Book;
import com.querys.query.model.Review;
import com.querys.query.service.LibraryService;

import java.util.List;

@Controller
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "index"; // Renders src/main/resources/templates/index.html
    }

    // Displays all books (JPQL without parameters)
    @GetMapping("/books")
    public String showAllBooks(Model model) {
        List<Book> books = libraryService.findAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("queryType", "All Books");
        return "books"; // Renders src/main/resources/templates/books.html
    }

    // Displays books by a specific publisher (JPQL with parameters)
    @GetMapping("/books-by-publisher")
    public String showBooksByPublisher(@RequestParam(name = "publisher", required = false) String publisherName, Model model) {
        List<Book> books;
        String queryMessage;
        if (publisherName != null && !publisherName.isEmpty()) {
            books = libraryService.findBooksByPublisherName(publisherName);
            queryMessage = "Libros por Editorial: " + publisherName;
        } else {
            books = libraryService.findAllBooks(); // Fallback to all books if no publisher is provided
            queryMessage = "Todos los libros (no se especifico editorial)";
        }
        model.addAttribute("books", books);
        model.addAttribute("queryType", queryMessage);
        return "books"; // Reuses the books.html template
    }

    // Displays all authors (JPQL without parameters)
    @GetMapping("/authors")
    public String showAllAuthors(Model model) {
        List<Author> authors = libraryService.findAllAuthors();
        model.addAttribute("authors", authors);
        model.addAttribute("queryType", "All Authors");
        return "authors"; // Renders src/main/resources/templates/authors.html
    }

    // Displays authors by a specific genre (JPQL with parameters)
    @GetMapping("/authors-by-genre")
    public String showAuthorsByGenre(@RequestParam(name = "genre", required = false) String genreName, Model model) {
        List<Author> authors;
        String queryMessage;
        if (genreName != null && !genreName.isEmpty()) {
            authors = libraryService.findAuthorsByGenre(genreName);
            queryMessage = "Géneros de libros y sus autores " + genreName;
        } else {
            authors = libraryService.findAllAuthors(); // Fallback to all authors if no genre is provided
            queryMessage = "Todos los autores (sin especificar género)";
        }
        model.addAttribute("authors", authors);
        model.addAttribute("queryType", queryMessage);
        return "authors"; // Reuses the authors.html template
    }

    // Displays reviews for a specific book title (JPQL with parameters)
    @GetMapping("/reviews-by-book")
    public String showReviewsByBook(@RequestParam(name = "bookTitle", required = false) String bookTitle, Model model) {
        List<Review> reviews;
        String queryMessage;
        if (bookTitle != null && !bookTitle.isEmpty()) {
            reviews = libraryService.findReviewsByBookTitle(bookTitle);
            queryMessage = "Reseñas por Libro: " + bookTitle;
        } else {
            reviews = List.of(); // No book title provided, show no reviews
            queryMessage = "Porfavor ingrese un título de libro para ver sus reseñas";
        }
        model.addAttribute("reviews", reviews);
        model.addAttribute("queryType", queryMessage);
        model.addAttribute("bookTitleParam", bookTitle); // Pass back the provided book title for the form
        return "reviews"; // Renders src/main/resources/templates/reviews.html
    }
}