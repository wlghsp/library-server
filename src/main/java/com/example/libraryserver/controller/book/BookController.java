package com.example.libraryserver.controller.book;

import com.example.libraryserver.dto.book.request.BookCreateRequest;
import com.example.libraryserver.dto.book.request.BookLoanRequest;
import com.example.libraryserver.dto.book.request.BookReturnRequest;
import com.example.libraryserver.dto.book.request.BookUpdateRequest;
import com.example.libraryserver.dto.book.response.BookLoanHistoryResponse;
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

    @PutMapping("/book")
    public void updateBook(@RequestBody BookUpdateRequest request) {
        bookService.updateBook(request);
    }

    @GetMapping("/book/history/{id}")
    public List<BookLoanHistoryResponse> getBookHistory(@PathVariable Long id) {
        return bookService.getBookLoanHistoryList(id);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        bookService.returnBook(request);
    }

}
