package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.ReactionResponse;

import java.util.List;

public interface ReactionService {
    ApiResponse<List<ReactionResponse>> getAllReactions();
}
