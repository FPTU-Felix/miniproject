package com.miniproject.miniproject.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    @NotBlank(message = "Username can't blank")
    private String username;
    @NotBlank(message = "Password can't blank")
    private String password;
    @NotBlank(message = "Input your fullname")
    private String fullName;
    private String email;
    private String phoneNumber;
}
