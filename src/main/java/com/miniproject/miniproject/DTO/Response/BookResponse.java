package com.miniproject.miniproject.DTO.Response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BookResponse {
    private String name;
    private String coverImg;
    private Double price;
    private String publishDate;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
