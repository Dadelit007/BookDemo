package com.example.demo.api;

import com.example.demo.document.BookDocument;
import com.example.demo.entity.BookEntity;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/books")
public class BookControllerApi{

    @Autowired
    private BookService bookService;

    @GetMapping("/mongo")
    public ResponseEntity<List> getAllBooksMongo() {
        try {
            List listOfBooks = bookService.getAllBooksMongo();
            if (listOfBooks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mongo/{id}")
    public ResponseEntity getBookByIdMongo(@PathVariable("id") String id) {
        try {
            Optional<BookDocument> bookDocument = bookService.getBookByIdMongo(id);
            return new ResponseEntity<>(bookDocument.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/mongo")
    public ResponseEntity addABookToLibraryMongo(@RequestBody BookDocument book) {
        try {
            BookDocument createdBook = bookService.addABookToLibraryMongo(book);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/mongo/{id}")
    public ResponseEntity updateABook(@PathVariable("id") String id, @RequestBody BookDocument book) {
        Optional <BookDocument> bookOptional = bookService.updateABookMongo(id,book);
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/mongo/{id}")
    public ResponseEntity deleteABook(@PathVariable("id") String id) {
        try {
            bookService.deleteABookMongo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jpa")
    public ResponseEntity<List> getAllBooksjpa() {
        try {
            List listOfBooks = bookService.getAllBooksJpa();
            if (listOfBooks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/jpa")
    public ResponseEntity addABookToLibraryMongo(@RequestBody BookEntity book) {
        try {
            BookEntity createdBook = bookService.addABookToLibraryJpa(book);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
