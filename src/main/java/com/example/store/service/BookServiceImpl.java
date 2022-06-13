package com.example.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.store.model.Book;
import com.example.store.dto.BookDTO;
import com.example.store.repository.BookRepo;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;
    
    public List<BookDTO> findBooksByAuthorId(Long authorId) {
        List<Book> books = bookRepo.findAllBookByAuthorId(authorId);
        if (books.size() == 0) {
            return new ArrayList<>();
        }

        List<BookDTO> booksDTO = new ArrayList<>();
        BookDTO bookDTO = new BookDTO();

        for (Book book: books) {
            bookDTO.loadFromEntity(book);
            booksDTO.add(bookDTO);
        }

        return booksDTO;
    }

    public BookDTO findBookByBookId(Long bookId) {
        BookDTO bookDto = new BookDTO();
        Optional<Book> book = bookRepo.findById(bookId);

        if (book.isPresent()) {
            bookDto.loadFromEntity(book.get());
        }

        return bookDto;
    }
}
