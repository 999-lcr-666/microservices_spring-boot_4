package com.lcr.author.client;

import com.lcr.author.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "book-service", url = "${application.config.books-url}")
public interface BookClient {

    @GetMapping("/author/{author-id}")
    List<Book> findAllBooksByAuthor(@PathVariable("author-id") Integer authorId);
}
