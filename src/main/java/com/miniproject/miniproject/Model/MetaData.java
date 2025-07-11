package com.miniproject.miniproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    // Getters and setters
}
