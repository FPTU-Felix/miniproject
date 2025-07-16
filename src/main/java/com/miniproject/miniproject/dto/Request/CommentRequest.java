package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    @NotBlank(message = "Content is required")
    private String content;
}
