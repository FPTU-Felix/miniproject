package com.miniproject.miniproject.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ReactionRequest {
    private String type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
