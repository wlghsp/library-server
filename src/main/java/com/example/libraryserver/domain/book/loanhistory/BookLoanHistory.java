package com.example.libraryserver.domain.book.loanhistory;

import com.example.libraryserver.domain.book.Book;
import com.example.libraryserver.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class BookLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;

    private LocalDateTime loanDate; // 대출 일자

    private LocalDateTime returnDate; // 반납 일자

    public BookLoanHistory(Book book, User user) {
        this.book = book;
        this.user = user;
        this.bookName = book.getBookName();
        this.isReturn = false;
        this.loanDate = LocalDateTime.now();
    }

    public void doReturn() {
        this.isReturn = true;
        this.returnDate = LocalDateTime.now();
    }
}
