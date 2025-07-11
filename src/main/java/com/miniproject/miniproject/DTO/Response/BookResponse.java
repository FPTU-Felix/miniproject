package com.miniproject.miniproject.DTO.Response;

import lombok.Data;

@Data
public class BookResponse {
    private String name;
    private String coverImg;
    private Double price;
    private String publishDate;
    private String createdAt;
    private String lastUpdate;
}
