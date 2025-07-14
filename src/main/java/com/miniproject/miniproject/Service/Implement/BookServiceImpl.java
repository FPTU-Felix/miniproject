package com.miniproject.miniproject.Service.Implement;

import java.util.List;
import java.util.stream.Collectors;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import com.miniproject.miniproject.Model.Book;
import com.miniproject.miniproject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miniproject.miniproject.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public ApiResponse<List<BookResponse>> getAllBooks() {
        List<BookResponse> books = bookRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), books, null);
    }

    @Override
    public ApiResponse<BookResponse> getBookById(String id) {
        Book book = bookRepository.findById(id).orElse(null);
        BookResponse bookResponse = mapToResponse(book);
        return (book != null) ? new ApiResponse<>(String.valueOf(HttpStatus.OK), bookResponse, null) : new ApiResponse<>(String.valueOf(HttpStatus.NOT_FOUND), null, null); // Rut gon lai code ban
    }

    @Override
    public BookResponse addBook(BookRequest request) {
        Book b = mapToEntity(request);
        Book saved = bookRepository.save(b);
        return mapToResponse(saved);
    }

    @Override
    public ApiResponse<BookResponse> updateBook(String id, BookRequest request) {
        if (bookRepository.existsById(id)) {
            Book b = mapToEntity(request);
            b.setId(id);
            Book updated = bookRepository.save(b);
            return new ApiResponse<>("Sucess", mapToResponse(updated), null);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }


//    @Override
//    public Page<BookResponse> searchBooks(String title, String author, String publisher, String language, Integer minPage, Integer maxPage, Pageable pageable) {
//        Page<Book> bookPage = bookRepository.searchBooks(title, author, publisher, language, minPage, maxPage, pageable);
//        return bookPage.map(this::mapToResponse);
//    }


    //Mapping DTO
    private BookResponse mapToResponse(Book book) {
        BookResponse b = new BookResponse();
        b.setName(book.getName());
        b.setCoverImg(book.getCoverImg());
        b.setPrice(book.getPrice());
        b.setPublishDate(book.getPublishDate());
        b.setCreatedAt(book.getCreatedAt());
        b.setLastUpdate(book.getUpdatedAt());
        return b;
    }

    //maping entity
    private Book mapToEntity(BookRequest request) {
        Book b = new Book();
        b.setName(request.getName());
        b.setCoverImg(request.getCoverImg());
        b.setPrice(request.getPrice());
        b.setPublishDate(request.getPublishDate());
        b.setCreatedAt(request.getCreatedAt());
        b.setUpdatedAt(request.getLastUpdate());
        return b;
    }
}
