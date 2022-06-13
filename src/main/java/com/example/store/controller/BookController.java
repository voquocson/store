package com.example.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.dto.BookDTO;
import com.example.store.service.BookServiceImpl;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/v1/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(value = "/book_id")
    public BookDTO getBookByBookId(@PathVariable(value = "book_id") Long bookId) {
        if (bookId == null || bookId <= 0) {
            return new BookDTO();
        }

        BookDTO book = bookService.findBookByBookId(bookId);
        return book;
    }

    @GetMapping(value = "/author_id")
    public List<BookDTO> getBookByAuthorId(@PathVariable(value = "author_id") Long authorId) {
        if (authorId == null || authorId <= 0) {
            return new ArrayList<>();
        }

        List<BookDTO> books = bookService.findBooksByAuthorId(authorId);
        return books;
    }
}
