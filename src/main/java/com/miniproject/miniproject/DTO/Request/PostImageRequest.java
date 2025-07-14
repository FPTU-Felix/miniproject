package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostImageRequest {
    @NotBlank(message = "URL is required")
    private String img_url;
    @NotBlank(message = "CreatedAt is required")
    private LocalDateTime created_at;
    @NotBlank(message = "UpdatedAt is required")
    private LocalDateTime updated_at;
}
