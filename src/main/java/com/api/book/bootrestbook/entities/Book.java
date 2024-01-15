package com.api.book.bootrestbook.entities;

import jakarta.persistence.*;
import org.hibernate.dialect.MySQLDialect;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private int id;

    @Column(name="book_name")
    private String name;

    @Column(name="book_author")
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    public Book(int id,String name,Author author) {
        this.name = name;
        this.id=id;
        this.author=author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(){

    }


}
