package com.miniproject.miniproject.DTO.Response;

import lombok.Data;

@Data
public class BookResponse {
    private String code;
    private String title;
    private String author;
    private String publisher;
    private int page_count;
    private String print_type;
    private String language;
    private String description;
    private int quantity;
    private String created_at;//Chi mang thong tin cua BookRes => can qua 1 lop DTO nua mang thong tin trang
}
