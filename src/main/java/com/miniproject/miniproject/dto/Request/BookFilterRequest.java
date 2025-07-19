package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookFilterRequest extends PaginationRequest {
    private String publisher;
    private String title;
    private String id;
    private String category;
}
