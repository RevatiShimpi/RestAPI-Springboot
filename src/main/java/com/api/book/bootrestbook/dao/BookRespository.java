package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
