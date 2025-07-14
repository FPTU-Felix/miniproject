package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.CommentResponse;

import java.util.List;

public interface CommentService {
    ApiResponse<List<CommentResponse>> getAllComments();
}
