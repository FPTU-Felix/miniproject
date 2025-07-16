package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
}
