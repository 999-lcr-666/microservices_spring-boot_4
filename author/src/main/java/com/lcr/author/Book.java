package com.lcr.author;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String firstname;
    private String lastname;
    private String email;
}
