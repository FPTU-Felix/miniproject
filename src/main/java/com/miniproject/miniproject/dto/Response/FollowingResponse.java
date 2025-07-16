package com.miniproject.miniproject.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class FollowingResponse {
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
