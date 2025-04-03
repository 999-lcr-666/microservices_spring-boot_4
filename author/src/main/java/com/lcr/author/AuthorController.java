package com.lcr.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Author author
    ) {
        service.saveAuthor(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity.ok(service.findAllAuthors());
    }

    @GetMapping("/with-books/{author-id}")
    public ResponseEntity<FullAuthorResponse> findAllAuthors(@PathVariable("author-id") Integer authorId) {
        return ResponseEntity.ok(service.findAuthorsWithBooks(authorId));
    }
}
