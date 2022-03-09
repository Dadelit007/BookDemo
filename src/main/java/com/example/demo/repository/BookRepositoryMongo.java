package com.example.demo.repository;

import com.example.demo.document.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositoryMongo extends MongoRepository<BookDocument, String>
{
    List findByTitleContaining(String title);
    List findByAuthor(String name);
}
