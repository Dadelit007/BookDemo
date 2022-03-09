package com.example.demo.service;

import com.example.demo.document.BookDocument;
import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepositoryJpa;
import com.example.demo.repository.BookRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryMongo bookRepositoryMongo;

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Override
    public List<BookDocument> getAllBooksMongo() {
           return bookRepositoryMongo.findAll();
    }

    @Override
    public Optional<BookDocument> getBookByIdMongo(String id) {
            return bookRepositoryMongo.findById(id);
    }

    @Override
    public BookDocument addABookToLibraryMongo(BookDocument book) {
            return bookRepositoryMongo.save(book);
    }

    @Override
    public Optional<BookDocument> updateABookMongo(String id, BookDocument book) {
        Optional<BookDocument> bookOptional = bookRepositoryMongo.findById(id);
        if (bookOptional.isPresent()) {
            BookDocument updatedBook = bookOptional.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setIsbn(book.getIsbn());
            bookRepositoryMongo.save(updatedBook);
        }
        return bookOptional;
    }

    @Override
    public void deleteABookMongo(String id) {
        bookRepositoryMongo.deleteById(id);
    }

    @Override
    public List<BookEntity> getAllBooksJpa() {
        return bookRepositoryJpa.findAll();
    }

    @Override
    public BookEntity addABookToLibraryJpa(BookEntity book) {
        return bookRepositoryJpa.save(book);
    }
}