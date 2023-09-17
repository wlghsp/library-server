package com.example.libraryserver.service.book;

import com.example.libraryserver.domain.book.Book;
import com.example.libraryserver.domain.book.BookRepository;
import com.example.libraryserver.domain.user.User;
import com.example.libraryserver.domain.user.UserRepository;
import com.example.libraryserver.domain.user.loanhistory.UserLoanHistoryRepository;
import com.example.libraryserver.dto.book.request.BookCreateRequest;
import com.example.libraryserver.dto.book.request.BookLoanRequest;
import com.example.libraryserver.dto.book.request.BookReturnRequest;
import com.example.libraryserver.dto.book.request.BookUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getBookName()));
    }

    @Transactional
    public void updateBook(BookUpdateRequest request) {
        Book book = bookRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        book.updateBookName(request.getBookName());
    }


    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByBookName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getBookName(), false)) {
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다.");
        }

        User user = userRepository.findByUserId(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        user.loanBook(book.getBookName());
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        user.returnBook(request.getBookName());
    }


}
