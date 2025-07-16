package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostImageRequest {
    @NotBlank(message = "URL is required")
    private String img_url;
}
