package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;

import java.util.List;

public interface CommentService {
    ApiResponse<List<CommentResponse>> getAllComments();
}
