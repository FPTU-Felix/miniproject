package com.miniproject.miniproject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    private String userName;
    private String password;
}
