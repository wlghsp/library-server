package com.example.libraryserver.dto.book.response;

import com.example.libraryserver.domain.book.Book;
import lombok.Getter;

@Getter
public class BookResponse {
    private long id;
    private String bookName;
    private String author;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.bookName = book.getBookName();
        this.author = book.getAuthor();
    }
}