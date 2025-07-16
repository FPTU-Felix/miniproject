package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostRequest {
     @NotBlank(message = "Can leave title blank")
    private String title;
     @NotBlank(message = "Can leave content blank")
    private String content;
}
