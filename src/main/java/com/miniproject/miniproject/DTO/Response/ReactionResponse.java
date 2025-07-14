package com.miniproject.miniproject.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ReactionResponse {
    private String type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
