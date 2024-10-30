package com.example.ReactiveLibrary.services;

import com.example.ReactiveLibrary.entities.Book;
import com.example.ReactiveLibrary.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findBookMethodTest(){

        Mono<Book> nameMono = bookRepository.findByName("front end");
        StepVerifier.create(nameMono)
                .expectNextCount(1)
                .verifyComplete();

    }

    @Test
     void findAuthorMethodTest(){
        Flux<Book> authorFlux = bookRepository.findByAuthor("ravi rampal");
        StepVerifier.create(authorFlux)
                .expectNextCount(2)
                .verifyComplete();
    }
    @Test
    void findByNameAndAuthor()  {
    bookRepository.findByNameAndAuthor("","")
            .as(StepVerifier::create)
            .expectNextCount(1)
            .verifyComplete();
    }
    @Test
    public void queryMethodsTest(){
        bookRepository.getAllBooksByAuthor("Basic Python Book"," Python rocker")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }
    @Test
    public void queryMethodsTest1(){

        bookRepository.searchBookByTittle("%front%")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }
}

