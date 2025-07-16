package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherRequest {
    @NotBlank(message = "Sponsored is required")
    private boolean isSponsored;
}
