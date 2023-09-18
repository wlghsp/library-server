package com.example.libraryserver.service.book;

import com.example.libraryserver.domain.book.Book;
import com.example.libraryserver.domain.book.BookRepository;
import com.example.libraryserver.domain.book.loanhistory.BookLoanHistoryRepository;
import com.example.libraryserver.domain.user.User;
import com.example.libraryserver.domain.user.UserRepository;
import com.example.libraryserver.dto.book.request.BookCreateRequest;
import com.example.libraryserver.dto.book.request.BookLoanRequest;
import com.example.libraryserver.dto.book.request.BookReturnRequest;
import com.example.libraryserver.dto.book.request.BookUpdateRequest;
import com.example.libraryserver.dto.book.response.BookLoanHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookLoanHistoryRepository bookLoanHistoryRepository;
    private final UserRepository userRepository;

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

        if (bookLoanHistoryRepository.existsByBookAndIsReturn(book, false)) {
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다.");
        }

        User user = userRepository.findByUserId(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        book.loanBook(user);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(IllegalArgumentException::new);

        book.returnBook(book);
    }

    @Transactional(readOnly = true)
    public List<BookLoanHistoryResponse> getBookLoanHistoryList(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return book.getBookLoanHistories().stream()
                .map(BookLoanHistoryResponse::new)
                .collect(Collectors.toList());
    }
}
