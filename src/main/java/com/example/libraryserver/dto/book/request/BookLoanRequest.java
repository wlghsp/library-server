package com.example.libraryserver.dto.book.request;

import lombok.Getter;

@Getter
public class BookLoanRequest {
    private String userId;
    private Long bookId;
}
