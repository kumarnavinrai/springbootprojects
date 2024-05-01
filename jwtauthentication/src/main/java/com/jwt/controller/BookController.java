package com.jwt.controller;

import com.jwt.model.Book;
import com.jwt.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${project.properties.name}")
    private String myPropertyName;

    // Create a new book
    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }

    // Read all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        System.out.println(myPropertyName);
        return bookService.findAll();
    }

    // Read a book by ID
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // Update a book
    @PutMapping("/books/{id}")
    public Book updateBook(@Valid @PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        book.setBook_name(bookDetails.getBook_name());
        // Update other book fields based on your model
        book.setAuthors(bookDetails.getAuthors()); // Update authors list
        return bookService.save(book);
    }

    // Delete a book
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookService.deleteById(id);
        return "Book deleted successfully!";
    }

    // You can add additional methods specific to Book management here
    // For example, finding books by author or genre (if applicable)
//    @GetMapping("/books/authors/{authorId}")
//    public List<Book> findBooksByAuthorId(@PathVariable Long authorId) {
//        return bookService.findBooksByAuthorId(authorId);
//    }
}

