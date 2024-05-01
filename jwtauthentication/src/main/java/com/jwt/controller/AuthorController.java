package com.jwt.controller;

import com.jwt.model.Author;
import com.jwt.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Create a new author
    @PostMapping("/authors")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorService.save(author);
    }

    // Read all authors
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    // Read an author by ID
    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    // Update an author
    @PutMapping("/authors/{id}")
    public Author updateAuthor(@Valid @PathVariable Long id, @RequestBody Author authorDetails) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        author.setAuthor_name(authorDetails.getAuthor_name());
        // Add other update logic based on your Author model fields
        return authorService.save(author);
    }

    // Delete an author
    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        authorService.deleteById(id);
        return "Author deleted successfully!";
    }


}

