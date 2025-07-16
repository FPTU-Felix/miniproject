package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NotBlank(message = "Enter Username!")
    private String username;
    @NotBlank(message = "Enter Password!")
    private String password;
}
