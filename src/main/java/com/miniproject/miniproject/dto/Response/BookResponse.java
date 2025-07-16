package com.miniproject.miniproject.dto.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookResponse {
    private String name;
    private String coverImg;
    private Double price;
    private String publishDate;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
