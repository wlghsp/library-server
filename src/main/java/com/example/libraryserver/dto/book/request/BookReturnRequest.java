package com.example.libraryserver.dto.book.request;

import lombok.Getter;

@Getter
public class BookReturnRequest {
    private String userId;
    private String bookName;

}
