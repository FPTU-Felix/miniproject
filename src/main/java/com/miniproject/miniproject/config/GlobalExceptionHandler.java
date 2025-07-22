package com.miniproject.miniproject.config;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.exception.GeneralException;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ApiResponse<?>> handleRuntimeException(RuntimeException exception){
//        ApiResponse<?> response = new ApiResponse<>("Internal Sever Error", exception.getMessage(), null);
//        return ResponseEntity.status(500).body(response);
//    }
    //Bat loi validate @valid

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handleServerError(RuntimeException ex) {
        ApiResponse<?> response = new ApiResponse<>(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralServerError(GeneralException ex) {
        ApiResponse<?> response = new ApiResponse<>(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(ResourceNotFoundException ex) {
        ApiResponse<?> response = new ApiResponse<>(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Handle validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> err = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        fieldError -> fieldError.getField(), // Key là tên trường
                        fieldError -> fieldError.getDefaultMessage()));
        ApiResponse<Map<String, String>> response = new ApiResponse<>("Validation Failed", err);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Handle Forbitdden exception
    @ExceptionHandler(AccessException.class)
    public ResponseEntity<ApiResponse<?>> handleAccessDenied(AccessException ex) {
        ApiResponse<?> response = new ApiResponse<>("Forbidden: " + ex.getMessage(), null);
        return ResponseEntity.status(403).body(response);
    }

    //Handle Unauthorize exception
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<?>> handleAuthentication(AuthenticationException exception) {
        ApiResponse<?> response = new ApiResponse<>("Unauthentication: " + exception.getMessage(), null);
        return ResponseEntity.status(401).body(response);
    }
}
