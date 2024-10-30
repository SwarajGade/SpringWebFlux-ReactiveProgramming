package com.example.ReactiveLibrary.repositories;

import com.example.ReactiveLibrary.entities.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book ,Integer> {
    //find methods and query methods.

    Mono<Book> findByName(String name);

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByPublisher(String publisher);

    Flux<Book> findByNameAndAuthor(String name,String author);

    @Query("select * from book_details where name = :name AND author = :author")
    Flux<Book> getAllBooksByAuthor(String name , String author);


    @Query("select * from book_details where name  LIKE :tittle")
    Flux<Book> searchBookByTittle(String tittle);
}

