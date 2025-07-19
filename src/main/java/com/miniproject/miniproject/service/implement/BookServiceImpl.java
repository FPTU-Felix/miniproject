package com.miniproject.miniproject.service.implement;

import java.util.List;
import java.util.stream.Collectors;
import com.miniproject.miniproject.Speicification.BookSpecification;
import com.miniproject.miniproject.dto.Request.BookFilterRequest;
import com.miniproject.miniproject.dto.Request.BookRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.BookResponse;
import com.miniproject.miniproject.model.Book;
import com.miniproject.miniproject.model.Mapper.BookMapper;
import com.miniproject.miniproject.model.MetaData;
import com.miniproject.miniproject.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miniproject.miniproject.repository.BookRepository;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
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
    public ApiResponse<List<BookResponse>> getBooks(BookFilterRequest request) {
        try {
            Specification<Book> spec = BookSpecification.getBooks(request);
            Pageable pageable = PageRequest.of(request.getPageIndex(), request.getPageSize());
            Page<Book> bookPage = bookRepository.findAll(spec, pageable);
            List<BookResponse> bookResponseList = bookPage.getContent().stream().map(bookMapper::toDTO).toList();
            return new ApiResponse<>(
                    "success",
                    bookResponseList,
                    new MetaData(bookPage.getNumber(), bookPage.getSize(), bookPage.getTotalPages(), bookPage.getTotalElements())
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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
