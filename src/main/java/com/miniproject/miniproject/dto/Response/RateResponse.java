package com.miniproject.miniproject.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class RateResponse {
    private int score;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
