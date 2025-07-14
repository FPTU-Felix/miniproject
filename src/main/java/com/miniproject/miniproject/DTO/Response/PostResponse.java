package com.miniproject.miniproject.DTO.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostResponse {
    private String posted_by;
    private String title;
    private String content;
}
