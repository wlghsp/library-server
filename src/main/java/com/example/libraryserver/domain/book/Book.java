package com.example.libraryserver.domain.book;

import com.example.libraryserver.domain.book.loanhistory.BookLoanHistory;
import com.example.libraryserver.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookLoanHistory> bookLoanHistories = new ArrayList<>();

    public Book(String bookName, String author) {
        if (bookName == null || bookName.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 bookName(%s)이 들어왔습니다", bookName));
        }
        this.bookName = bookName;
        this.author = author;
    }

    public void updateBook(String name, String author) {
        this.bookName = name;
        this.author = author;
    }

    public void loanBook(User user) {
        this.bookLoanHistories.add(new BookLoanHistory(this, user));
    }

    public void returnBook(Book book) {
        BookLoanHistory bookLoanHistory = this.bookLoanHistories.stream()
                .filter(history -> history.getBook().equals(book))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        bookLoanHistory.doReturn();
    }
}
