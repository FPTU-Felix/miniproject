package com.miniproject.miniproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
// nếu Exception này được văng ra và không được xử lý ở đâu khác, hãy tự động trả về cho client mã lỗi HTTP 404 (Not Found)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
