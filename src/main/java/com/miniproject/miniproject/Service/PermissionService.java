package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    ApiResponse<List<PermissionResponse>> getAllPermission();
}
