package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;

public interface BookService {

    ApiResponse<List<BookResponse>> getAllBooks();

    ApiResponse<BookResponse> getBookById(int id);

    BookResponse addBook(BookRequest request);

//    BookResponse updateBook(int id, BookRequest request);

    void deleteBook(int id);

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
