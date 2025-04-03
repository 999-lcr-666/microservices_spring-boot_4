package com.lcr.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public List<Book> findAllBooksByAuthor(Integer authorId) {
        return repository.findAllByAuthorId(authorId);
    }
}
