package com.example.store.service;

import java.util.List;

import com.example.store.dto.BookDTO;

public interface BookService {

    List<BookDTO> findBooksByAuthorId(Long authorId);

    BookDTO findBookByBookId(Long bookId);
}
