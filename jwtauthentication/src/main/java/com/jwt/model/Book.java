package com.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;

    @JsonIgnoreProperties("books")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
            }
    )
    private List<Author> authors = new ArrayList<>();

    @JsonIgnoreProperties("books")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Long getBook_id() {
        return bookId;
    }

    public void setBook_id(Long book_id) {
        this.bookId = book_id;
    }

    public String getBook_name() {
        return bookName;
    }

    public void setBook_name(String book_name) {
        this.bookName = book_name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }



}