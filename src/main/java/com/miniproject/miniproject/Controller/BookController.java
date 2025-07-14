package com.miniproject.miniproject.Controller;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miniproject.miniproject.Service.BookService;

@RestController
@RequestMapping("/api/v1/library/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ApiResponse<List<BookResponse>> getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ApiResponse<BookResponse> getBookById(@PathVariable String id) {//@Pathvariable are used to get data from url
        return bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody @Valid BookRequest request) {//Request body is used to automatic change Json into Object to fit with data type (here is BookRequest)
        BookResponse createdBook = bookService.addBook(request);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ApiResponse<BookResponse> updateBook(@PathVariable String id, @RequestBody @Valid BookRequest request) {//Valid is used to active validation for BookRequest and only work when DTO has annotation to validate
        return bookService.updateBook(id, request);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<BookResponse>> searchBooks(//ResponseEntity is used to add status code and header go with return data
//                                                          @ModelAttribute BookFilterRequest filterRequest,
//                                                          @RequestParam(defaultValue = "0") int page,
//                                                          @RequestParam(defaultValue = "10") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<BookResponse> results = bookService.searchBooks(
//                filterRequest.getTitle(),
//                filterRequest.getAuthor(),
//                filterRequest.getPublisher(),
//                filterRequest.getLanguage(),
//                filterRequest.getMinPage(),
//                filterRequest.getMaxPage(),
//                pageable
//        );
//        return ResponseEntity.ok(results);
//    }

}
