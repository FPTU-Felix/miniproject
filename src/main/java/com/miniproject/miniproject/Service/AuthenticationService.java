package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(UserLoginRequest request);
}
