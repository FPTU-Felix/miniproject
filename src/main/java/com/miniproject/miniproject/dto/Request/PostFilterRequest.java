package com.miniproject.miniproject.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFilterRequest extends PaginationRequest{
    private String id;
    private String title;
    private String book;
    private String chapter;
    private String user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
