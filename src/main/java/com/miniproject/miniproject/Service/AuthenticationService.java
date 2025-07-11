package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.AuthenticationResponse;

public interface AuthenticationService {
    ApiResponse login(UserLoginRequest request);
}
