package com.miniproject.miniproject.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginationRequest {
    private int pageIndex = 0;
    private int pageSize = 10;
    private String sortBy;
    private String direction;
}
