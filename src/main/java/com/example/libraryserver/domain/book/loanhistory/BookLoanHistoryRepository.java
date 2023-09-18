package com.example.libraryserver.domain.book.loanhistory;

import com.example.libraryserver.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookLoanHistoryRepository extends JpaRepository<BookLoanHistory, Long> {

    boolean existsByBookAndIsReturn(Book book, boolean isReturn);

}
