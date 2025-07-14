package com.miniproject.miniproject.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PublisherResponse {
    private boolean is_sponsored;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
