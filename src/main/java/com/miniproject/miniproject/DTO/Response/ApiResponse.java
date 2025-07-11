package com.miniproject.miniproject.DTO.Response;

import com.miniproject.miniproject.Model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // <- exclude metadata if null
public class ApiResponse<T> {
    private String status;
    private T data;
    private MetaData metadata;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(String status, T data, MetaData metadata) {
        this.status = status;
        this.data = data;
        this.metadata = metadata;
    }
}
