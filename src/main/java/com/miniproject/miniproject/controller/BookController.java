package com.miniproject.miniproject.controller;

import java.util.List;

import com.miniproject.miniproject.dto.Request.BookFilterRequest;
import com.miniproject.miniproject.dto.Request.BookRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.miniproject.miniproject.service.BookService;

@RestController
@RequestMapping("/api/v1/library/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping
//    public ApiResponse<List<BookResponse>> getAllBook() {
//        return bookService.getAllBooks();
//    }

    @GetMapping("/{id}")
    public ApiResponse<BookResponse> getBookById(@PathVariable String id) {//@Pathvariable are used to get data from url
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<BookResponse>> createBook(@RequestBody @Valid BookRequest request, Authentication authentication) {//Request body is used to automatic change Json into Object to fit with data type (here is BookRequest)
        String publisherId = authentication.getName();
        BookResponse createdBook = bookService.addBook(request, publisherId);
        ApiResponse<BookResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.CREATED),createdBook);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<BookResponse> updateBook(@PathVariable String id, @RequestBody @Valid BookRequest request) {//Valid is used to active validation for BookRequest and only work when DTO has annotation to validate
        return bookService.updateBook(id, request);
    }

    @GetMapping
    public ApiResponse<List<BookResponse>> getBooks(@ModelAttribute BookFilterRequest request) {
        return bookService.getBooks(request);
    }

}
