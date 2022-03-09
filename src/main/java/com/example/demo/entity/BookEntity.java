package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(length = 24)
        private Long id;

        private String title;
        private String author;
        private String isbn;

}
