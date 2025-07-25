package com.miniproject.miniproject.service;

import java.util.List;

import com.miniproject.miniproject.dto.Request.BookFilterRequest;
import com.miniproject.miniproject.dto.Request.BookRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.BookResponse;

public interface BookService {

    ApiResponse<List<BookResponse>> getAllBooks();

    ApiResponse<BookResponse> getBookById(String id);

    BookResponse addBook(BookRequest request, String publisherId);

    ApiResponse<BookResponse> updateBook(String id, BookRequest request);

    ApiResponse<List<BookResponse>> getBooks(BookFilterRequest request);

    void deleteBook(String id);

//    Page<BookResponse> searchBooks(
//            String title,
//            String author,
//            String publisher,
//            String language,
//            Integer minPage,
//            Integer maxPage,
//            Pageable pageable
//    );
}
