package com.example.libraryserver.dto.book.response;

import com.example.libraryserver.domain.book.loanhistory.BookLoanHistory;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookLoanHistoryResponse {

    private Long id;
    private long bookId;
    private String userId;
    private String bookName;
    private boolean isReturn;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    public BookLoanHistoryResponse(Long id, long bookId, String userId, String bookName, boolean isReturn, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = isReturn;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public BookLoanHistoryResponse(BookLoanHistory bookLoanHistory) {
        this.id = bookLoanHistory.getId();
        this.bookId = bookLoanHistory.getBook().getId();
        this.userId = bookLoanHistory.getUser().getUserId();
        this.bookName = bookLoanHistory.getBookName();
        this.isReturn = bookLoanHistory.isReturn();
        this.loanDate = bookLoanHistory.getLoanDate();
        this.returnDate = bookLoanHistory.getReturnDate();
    }

}
