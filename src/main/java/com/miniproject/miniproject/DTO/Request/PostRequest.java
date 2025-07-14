package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class PostRequest {
     @NotBlank(message = "Can leave posted_by blank")
    private String posted_by;
     @NotBlank(message = "Can leave title blank")
    private String title;
     @NotBlank(message = "Can leave content blank")
    private String content;
     @NotBlank(message = "Can leave time_created blank")
    private LocalDateTime created_at;
    @NotBlank(message = "UpdatedAt is required")
    private LocalDateTime updated_at;
}
