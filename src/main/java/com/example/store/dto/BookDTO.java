package com.example.store.dto;

import com.example.store.model.Book;

public class BookDTO {

    private Long id;

    private String name;

    private Integer publishYear;
    
    private Long authorId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void loadFromEntity(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.publishYear = book.getPublishYear();
        this.authorId = book.getAuthorId();
    }
}
