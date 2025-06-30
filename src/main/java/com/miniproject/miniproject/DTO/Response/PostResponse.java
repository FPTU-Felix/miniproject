package com.miniproject.miniproject.DTO.Response;

import lombok.Data;

@Data
public class PostResponse {
    private int user_id;
    private String title;
    private String content;
    private String created_at;
}
