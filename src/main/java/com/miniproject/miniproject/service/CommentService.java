package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllComments();

    List<CommentResponse> getCommentsByPostID(String postId);

    CommentResponse updateComment(String commentId, CommentRequest request);

    void deleteComment(String commentId, String currentUserId);

    CommentResponse replyComment(String userId, String parentCommentId, CommentRequest request);
}
