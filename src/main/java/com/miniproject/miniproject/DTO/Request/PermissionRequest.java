package com.miniproject.miniproject.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PermissionRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "CreatedAt is required")
    private LocalDateTime created_at;
    @NotBlank(message = "UpdatedAt is required")
    private LocalDateTime updated_at;
}
