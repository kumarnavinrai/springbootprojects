package com.jwt.services;

import com.jwt.model.Author;
import com.jwt.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }



    // You can add additional methods specific to Author entity here
    // For example, finding authors by book title
    // public List<Author> findAuthorsByBookTitle(String title) {
    //     // Implement logic to retrieve authors based on book title
    // }
}

