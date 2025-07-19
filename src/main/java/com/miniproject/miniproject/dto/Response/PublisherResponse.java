package com.miniproject.miniproject.dto.Response;

import com.miniproject.miniproject.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {
    private String id;
    private UserDTO user;
    private boolean isSponsored;
}
