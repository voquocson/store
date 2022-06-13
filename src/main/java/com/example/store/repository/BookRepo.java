package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.store.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    public Optional<Book> findById(Long id);
    
    @Query(value = "select * from book where author_id = ?1", nativeQuery = true)
    public List<Book> findAllBookByAuthorId(Long authorId);
}
