package com.example.libraryserver.dto.book.request;

import lombok.Getter;

@Getter
public class BookReturnRequest {
    private Long userId;
    private Long bookId;
}
