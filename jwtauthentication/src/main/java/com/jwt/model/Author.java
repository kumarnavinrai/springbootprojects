package com.jwt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long authorId;
    private String authorName;

    @ManyToMany(mappedBy = "authors",fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Long getAuthor_id() {
        return authorId;
    }

    public void setAuthor_id(Long author_id) {
        this.authorId = author_id;
    }

    public String getAuthor_name() {
        return authorName;
    }

    public void setAuthor_name(String author_name) {
        this.authorName = author_name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}