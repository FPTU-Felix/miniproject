package com.miniproject.miniproject.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {
    @NotBlank(message = "Code is required")
    private String code;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @NotBlank(message = "Publisher is required")
    private String publisher;
    @NotBlank(message = "Page Count is required")
    private int page_count;
    @NotBlank(message = "Print Type is required")
    private String print_type;
    @NotBlank(message = "Language is required")
    private String language;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "quantity is required")
    private int quantity;
    @NotBlank(message = "Time is required")
    private String created_at;
}
