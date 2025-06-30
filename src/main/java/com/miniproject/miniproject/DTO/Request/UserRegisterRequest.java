package com.miniproject.miniproject.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
}
