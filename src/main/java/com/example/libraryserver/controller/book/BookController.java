package com.example.libraryserver.controller.book;

import com.example.libraryserver.dto.book.request.BookCreateRequest;
import com.example.libraryserver.dto.book.request.BookLoanRequest;
import com.example.libraryserver.dto.book.request.BookReturnRequest;
import com.example.libraryserver.dto.book.request.BookUpdateRequest;
import com.example.libraryserver.dto.user.request.UserUpdateRequest;
import com.example.libraryserver.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {
        bookService.saveBook(request);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody BookUpdateRequest request) {
        bookService.updateBook(request);
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
