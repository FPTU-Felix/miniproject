package com.miniproject.miniproject.dto.Response;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String id;
    private String name;
    private String coverImg;
    private Double price;
    private String publishDate;
    private List<CategoryResponse> categories;
    private Double rate;
    private PublisherResponse publisher;
}
