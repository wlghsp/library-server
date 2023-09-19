package com.example.libraryserver.dto.book.request;

import lombok.Getter;

@Getter
public class BookUpdateRequest {
    private Long id;
    private String bookName;
    private String author;
}
