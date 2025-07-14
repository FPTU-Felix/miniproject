package com.miniproject.miniproject.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ChapterResponse {
    private LocalDateTime created_at;
    private String chapter_name;
    private String next_chapter;
    private String publish_at;
    private String type;
    private LocalDateTime updated_at;
}
