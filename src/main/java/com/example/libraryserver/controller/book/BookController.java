package com.example.libraryserver.controller.book;

import com.example.libraryserver.dto.book.request.BookCreateRequest;
import com.example.libraryserver.dto.book.request.BookLoanRequest;
import com.example.libraryserver.dto.book.request.BookReturnRequest;
import com.example.libraryserver.dto.book.request.BookUpdateRequest;
import com.example.libraryserver.dto.book.response.BookLoanHistoryResponse;
import com.example.libraryserver.dto.book.response.BookResponse;
import com.example.libraryserver.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {
        bookService.saveBook(request);
    }

    @GetMapping("/book")
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    @PutMapping("/book")
    public void updateBook(@RequestBody BookUpdateRequest request) {
        bookService.updateBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @GetMapping("/book/history/{bookId}")
    public List<BookLoanHistoryResponse> getBookHistory(@PathVariable Long bookId) {
        return bookService.getBookLoanHistoryList(bookId);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        bookService.returnBook(request);
    }

}
