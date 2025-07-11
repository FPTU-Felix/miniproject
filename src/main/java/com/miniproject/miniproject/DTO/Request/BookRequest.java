package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "coverImg is required")
    private String coverImg;
    @NotBlank(message = "price is required")
    private Double price;
    @NotBlank(message = "publishDate is required")
    private String publishDate;
    @NotBlank(message = "createdAt is required")
    private String createdAt;
    @NotBlank(message = "lastUpdate Type is required")
    private String lastUpdate;
}
