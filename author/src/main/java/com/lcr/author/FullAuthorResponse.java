package com.lcr.author;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullAuthorResponse {

    private String name;
    private String email;
    List<Book> books;
}
