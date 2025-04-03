package com.lcr.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Book book
    ) {
        service.saveBook(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping("/author/{author-id}")
    public ResponseEntity<List<Book>> findAllBooks(
            @PathVariable("author-id") Integer authorId
    ) {
        return ResponseEntity.ok(service.findAllBooksByAuthor(authorId));
    }
}
