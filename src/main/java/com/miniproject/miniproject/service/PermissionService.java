package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    ApiResponse<List<PermissionResponse>> getAllPermission();
}
