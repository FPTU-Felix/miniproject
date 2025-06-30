package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequest {
     @NotBlank(message = "Can leave user_id blank")
    private int user_id;
     @NotBlank(message = "Can leave title blank")
    private String title;
     @NotBlank(message = "Can leave content blank")
    private String content;
     @NotBlank(message = "Can leave time_created blank")
    private String created_at;
}
