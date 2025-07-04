package com.miniproject.miniproject.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class GeneralListResponse<T> {
    private T data;
    private String status;
}
