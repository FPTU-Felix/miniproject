package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.model.Reaction;

import java.util.List;

public interface ReactionService {
    ApiResponse<List<ReactionResponse>> getAllReactions();

    List<ReactionResponse> getReactionForPost(String post_id);

    ReactionResponse reactionComment(String commentId, String userId, ReactionRequest request);

    ReactionResponse reactionPost(String postId, String userId, ReactionRequest request);
}
