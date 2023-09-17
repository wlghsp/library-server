package com.example.libraryserver.domain.book.loanhistory;

import com.example.libraryserver.domain.user.loanhistory.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookLoanHistoryRepository extends JpaRepository<BookLoanHistory, Long> {

    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
