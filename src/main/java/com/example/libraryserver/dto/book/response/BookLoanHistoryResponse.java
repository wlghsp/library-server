package com.example.libraryserver.dto.book.response;

import com.example.libraryserver.domain.book.Book;
import com.example.libraryserver.domain.book.loanhistory.BookLoanHistory;
import com.example.libraryserver.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookLoanHistoryResponse {

    private Long id;

    private Book book;

    private User user;

    private String bookName;

    private boolean isReturn;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    public BookLoanHistoryResponse(Long id, Book book, User user, String bookName, boolean isReturn, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.bookName = bookName;
        this.isReturn = isReturn;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public BookLoanHistoryResponse(BookLoanHistory bookLoanHistory) {
        this.id = bookLoanHistory.getId();
        this.book = bookLoanHistory.getBook();
        this.user = bookLoanHistory.getUser();
        this.bookName = bookLoanHistory.getBookName();
        this.isReturn = bookLoanHistory.isReturn();
        this.loanDate = bookLoanHistory.getLoanDate();
        this.returnDate = bookLoanHistory.getReturnDate();
    }

}
