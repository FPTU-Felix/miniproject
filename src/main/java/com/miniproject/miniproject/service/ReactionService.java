package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;

import java.util.List;

public interface ReactionService {
    ApiResponse<List<ReactionResponse>> getAllReactions();
}
