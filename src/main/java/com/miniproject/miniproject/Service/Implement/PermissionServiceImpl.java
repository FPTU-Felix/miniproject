package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.PermissionRequest;
import com.miniproject.miniproject.DTO.Request.PostRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import com.miniproject.miniproject.DTO.Response.PermissionResponse;
import com.miniproject.miniproject.DTO.Response.PostResponse;
import com.miniproject.miniproject.Model.Permission;
import com.miniproject.miniproject.Model.Post;
import com.miniproject.miniproject.Repository.PermissionRepository;
import com.miniproject.miniproject.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public ApiResponse<List<PermissionResponse>> getAllPermission() {
        List<PermissionResponse> permissionResponses = permissionRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), permissionResponses, null);
    }

    private PermissionResponse mapToResponse(Permission permission) {
        PermissionResponse p = new PermissionResponse();
        p.setName(permission.getName());
        p.setDescription(permission.getDescription());
        p.setCreated_at(permission.getCreatedAt());
        p.setUpdated_at(permission.getUpdatedAt());
        return p;
    }

    private Permission mapToEntity(PermissionRequest request) {
        Permission p = new Permission();
        p.setName(request.getName());
        p.setDescription(request.getDescription());
        p.setCreatedAt(request.getCreated_at());
        p.setUpdatedAt(request.getUpdated_at());
        return p;
    }
}
