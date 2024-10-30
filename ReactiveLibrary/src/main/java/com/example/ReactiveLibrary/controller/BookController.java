package com.example.ReactiveLibrary.controller;


import com.example.ReactiveLibrary.entities.Book;
import com.example.ReactiveLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Provider;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //create

    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
        return bookService.create(book);
    }
    //get all books

    @GetMapping
    public Flux<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/{bid}")
    public Mono<Book> get(@PathVariable("bid") int bookId){
        return bookService.get(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId){
        return bookService.update(book ,bookId);
    }

    //delete

    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }

    @GetMapping("/search")
    public Flux<Book> searchBooks(
            @RequestParam("query") String query)
    {
        return this.bookService.searchBooks(query);
    }

}
