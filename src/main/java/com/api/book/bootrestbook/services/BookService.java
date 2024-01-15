package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRespository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private BookRespository bookRespository;
//    private static List<Book> list=new ArrayList<>();
//    static{
//        list.add(new Book(12,"Java book","ABC"));
//        list.add(new Book(11,"Java book2","LMN"));
//        list.add(new Book(13,"Java book3","WYA"));
//
//    }

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>)this.bookRespository.findAll();
        return list;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try{
            book=this.bookRespository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //add book
    public Book addBook(Book b){
        Book result=bookRespository.save(b);
        return result;
    }

    public void deletebook(int id){
        bookRespository.deleteById(id);
    }
    public void updateBook(Book book,int id){
//        list=list.stream().map(b->{
//            if(b.getId()==id){
//                b.setName(book.getName());
//            }
//            return b;
//        }).collect(Collectors.toList());
        book.setId(id);
        bookRespository.save(book);
    }
}
