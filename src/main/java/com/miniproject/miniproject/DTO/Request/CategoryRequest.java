package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CategoryRequest {
    private String categoryName;
    @NotBlank(message = "CreatedAt is required")
    private LocalDateTime created_at;
    @NotBlank(message = "UpdatedAt is required")
    private LocalDateTime updated_at;
}
