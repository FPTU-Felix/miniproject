package com.miniproject.miniproject.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CategoryResponse {
    private String category_name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
