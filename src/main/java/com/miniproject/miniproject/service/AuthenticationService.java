package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.UserLoginRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;

public interface AuthenticationService {
    ApiResponse login(UserLoginRequest request);
}
