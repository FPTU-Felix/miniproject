package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.service.CommentService;
import com.miniproject.miniproject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/social")
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;

    // Dùng constructor để inject, Spring sẽ tự động cung cấp các bean
    @Autowired
    public CommentController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getAllComment() {
        ApiResponse<List<CommentResponse>> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), commentService.getAllComments(), null);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/comments/{id}/reply")
    public ResponseEntity<ApiResponse<CommentResponse>> replyComment(@PathVariable String id, Authentication authentication, @RequestBody @Valid CommentRequest request) {
        return null;
    }

    @PutMapping("/comments/{id}/update")
    public ResponseEntity<ApiResponse<CommentResponse>> updateComment(@PathVariable String id, Authentication authentication, @RequestBody @Valid CommentRequest request) {
        return null;
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getCommentForPost(@PathVariable String postId) {
        List<CommentResponse> list = commentService.getCommentsByPostID(postId);
        ApiResponse<List<CommentResponse>> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), list, null);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<ApiResponse<CommentResponse>> postNewComment(@PathVariable String postId,
                                                                       Authentication authentication,
                                                                       @RequestBody @Valid CommentRequest request) {
        String user_id = authentication.getName();
        CommentResponse newComment = postService.postNewComment(postId, user_id, request);
        ApiResponse<CommentResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), newComment, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/delete/{commentId}")
    public ResponseEntity<ApiResponse<?>> deleteComment(@PathVariable String commentId,
                                                        Authentication authentication) {
        String user_id = authentication.getName();
        commentService.deleteComment(commentId, user_id);
        ApiResponse<?> response = new ApiResponse<>("Delete Comment Successfully", null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/comments/{parentCommentId}/replies")
    public ResponseEntity<ApiResponse<CommentResponse>> replyComment(@PathVariable String parentCommentId,
                                                                     @RequestBody @Valid CommentRequest request,
                                                                     Authentication authentication) {
        String userId = authentication.getName();
        CommentResponse replyComment = commentService.replyComment(userId, parentCommentId, request);
        ApiResponse<CommentResponse> response = new ApiResponse<>("Reply created successfully", replyComment, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
