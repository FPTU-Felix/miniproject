package com.miniproject.miniproject.Service.Implement;

import java.util.List;
import java.util.stream.Collectors;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import com.miniproject.miniproject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miniproject.miniproject.Model.Book;
import com.miniproject.miniproject.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        return (book != null) ? mapToResponse(book) : null; // Rut gon lai code ban
    }

    @Override
    public BookResponse addBook(BookRequest request) {
        Book b = mapToEntity(request);
        Book saved = bookRepository.save(b);
        return mapToResponse(saved);
    }

    @Override
    public BookResponse updateBook(int id, BookRequest request) {
        if (bookRepository.existsById(id)) {
            Book b = mapToEntity(request);
            b.setId(id);
            Book updated = bookRepository.save(b);
            return mapToResponse(updated);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


    @Override
    public Page<BookResponse> searchBooks(String title, String author, String publisher, String language, Integer minPage, Integer maxPage, Pageable pageable) {
        Page<Book> bookPage = bookRepository.searchBooks(title, author, publisher, language, minPage, maxPage, pageable);
        return bookPage.map(this::mapToResponse);
    }


    //Mapping DTO
    private BookResponse mapToResponse(Book book) {
        BookResponse b = new BookResponse();
        b.setCode(book.getCode());
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPublisher(book.getPublisher());
        b.setPage_count(book.getPageCount());
        b.setPrint_type(book.getPrintType());
        b.setLanguage(book.getLanguage());
        b.setDescription(book.getDescription());
        b.setQuantity(book.getQuantity());
        b.setCreated_at(book.getDateCreated());
        return b;
    }
    //maping entity
    private Book mapToEntity(BookRequest request) {
        Book book = new Book();
        book.setCode(request.getCode());
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublisher(request.getPublisher());
        book.setPageCount(request.getPage_count());
        book.setPrintType(request.getPrint_type());
        book.setLanguage(request.getLanguage());
        return book;
    }
}
