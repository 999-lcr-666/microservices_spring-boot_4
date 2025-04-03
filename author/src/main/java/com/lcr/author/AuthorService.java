package com.lcr.author;

import com.lcr.author.client.BookClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final BookClient client;

    public AuthorService(AuthorRepository repository, BookClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void saveAuthor(Author author) {
        repository.save(author);
    }

    public List<Author> findAllAuthors() {
        return repository.findAll();
    }

    public FullAuthorResponse findAuthorsWithBooks(Integer authorId) {
        var author = repository.findById(authorId)
                .orElse(
                        Author.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var books = client.findAllBooksByAuthor(authorId);
        return FullAuthorResponse.builder()
                .name(author.getName())
                .email(author.getEmail())
                .books(books)
                .build();
    }
}
