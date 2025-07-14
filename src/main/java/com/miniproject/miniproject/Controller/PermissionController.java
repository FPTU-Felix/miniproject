package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.PermissionResponse;
import com.miniproject.miniproject.Service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/auth/permission")
@RequiredArgsConstructor
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getAllPermission() {
        return permissionService.getAllPermission();
    }
}
