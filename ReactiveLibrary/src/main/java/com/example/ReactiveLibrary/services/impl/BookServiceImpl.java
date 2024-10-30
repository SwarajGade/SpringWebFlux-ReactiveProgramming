package com.example.ReactiveLibrary.services.impl;

import com.example.ReactiveLibrary.entities.Book;
import com.example.ReactiveLibrary.repositories.BookRepository;
import com.example.ReactiveLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
   private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
       Mono<Book> createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
       Mono<Book> item =bookRepository.findById(bookId);
        return item;
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
       Mono<Book>  oldBook =bookRepository.findById(bookId);
       return  oldBook.flatMap(book1 ->
       {
           book1.setName(book.getName());
           book1.setPublisher(book.getPublisher());
           book1.setAuthor(book.getAuthor());
           book1.setDescription(book.getDescription());
             return bookRepository.save(book1);
       });
    }

    @Override
    public Mono<Void> delete(int bookId) {
      return bookRepository
              .findById(bookId)
              .flatMap(book ->
                      bookRepository
                              .delete(book));
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }

    @Override
    public Flux<Book> searchBooks(String titleKeyword) {

        return this.bookRepository.searchBookByTittle("%"+titleKeyword+"%");
    }
}
