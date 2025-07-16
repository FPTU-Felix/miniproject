package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFilterRequest {
    private String title;
    private String author;
    private String publisher;
    private String language;
    private Integer minPage;
    private Integer maxPage;

    @Min(value = 0, message = "Page must be >= 0")
    private Integer page = 0;
    @Min(value = 1, message = "Size must be >= 1")
    private Integer size = 10;
    private String sortBy = "id";
    @Pattern(regexp = "^(asc|desc)$", message = "Direction must be 'asc' or 'desc'")
    private String direction = "asc";
}
