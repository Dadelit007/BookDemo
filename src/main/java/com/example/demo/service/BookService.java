package com.example.demo.service;

import com.example.demo.document.BookDocument;
import com.example.demo.entity.BookEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDocument> getAllBooksMongo();
    Optional<BookDocument> getBookByIdMongo(@PathVariable("id") String id);
    BookDocument addABookToLibraryMongo(@RequestBody BookDocument book);
    Optional<BookDocument> updateABookMongo(@PathVariable("id") String id, @RequestBody BookDocument book);
    void deleteABookMongo(@PathVariable("id") String id);
    List<BookEntity> getAllBooksJpa();
    BookEntity addABookToLibraryJpa(@RequestBody BookEntity book);
}
