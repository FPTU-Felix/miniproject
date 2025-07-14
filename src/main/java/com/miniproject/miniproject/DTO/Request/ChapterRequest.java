package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ChapterRequest {
    @NotBlank(message = "Name is required")
    private String chapter_name;
    @NotBlank(message = "Publish is required")
    private String publish_at;
    @NotBlank(message = "Type is required")
    private String type;
    @NotBlank(message = "Next_chapter is required")
    private String next_chapter;
    @NotBlank(message = "CreatedAt is required")
    private LocalDateTime created_at;
    @NotBlank(message = "UpdatedAt is required")
    private LocalDateTime updated_at;
}
