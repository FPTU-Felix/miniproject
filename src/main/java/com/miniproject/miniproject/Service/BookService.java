package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    List<BookResponse> getAllBooks();

    BookResponse getBookById(int id);

    BookResponse addBook(BookRequest request);

    BookResponse updateBook(int id, BookRequest request);

    void deleteBook(int id);

    Page<BookResponse> searchBooks(
            String title,
            String author,
            String publisher,
            String language,
            Integer minPage,
            Integer maxPage,
            Pageable pageable
    );
}
