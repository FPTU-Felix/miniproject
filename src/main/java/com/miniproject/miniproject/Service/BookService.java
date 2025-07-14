package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;

public interface BookService {

    ApiResponse<List<BookResponse>> getAllBooks();

    ApiResponse<BookResponse> getBookById(String id);

    BookResponse addBook(BookRequest request);

    ApiResponse<BookResponse> updateBook(String id, BookRequest request);

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
