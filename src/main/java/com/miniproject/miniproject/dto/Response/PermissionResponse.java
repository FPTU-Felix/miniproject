package com.miniproject.miniproject.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PermissionResponse {
    private String description;
    private String name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
