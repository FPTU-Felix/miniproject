package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.service.CommentService;
import com.miniproject.miniproject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/social")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    // Dùng constructor để inject, Spring sẽ tự động cung cấp các bean
    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }


    //Post Section
    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<PostResponse>>> getAllPosts() {
        List<PostResponse> list = postService.getAllPosts();
        ApiResponse<List<PostResponse>> response = new ApiResponse<>("Successfully", list, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<PostResponse>> getPostById(@PathVariable String postId) { //
        PostResponse postResponse = postService.getPostById(postId);
        ApiResponse<PostResponse> response = new ApiResponse<>("Founded", postResponse, null);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/posts")
    public ResponseEntity<ApiResponse<PostResponse>> addPost(@RequestBody @Valid PostRequest request, Authentication authentication) {
        String user_id = authentication.getName();
        PostResponse postRes = postService.addPost(request, user_id);
        ApiResponse<PostResponse> apiResponse = new ApiResponse<>("Created Successfully", postRes, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<PostResponse>> updatedPost(@RequestBody @Valid PostRequest request, @PathVariable String postId) {
        PostResponse responsePost = postService.updatePost(postId, request);
        ApiResponse<PostResponse> response = new ApiResponse<>("Post Updated Successfully", responsePost, null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<?>> deletePost(@PathVariable String postId, Authentication authentication) {
        String current_user_id = authentication.getName();
        postService.deletePost(postId, current_user_id);
        ApiResponse<?> response = new ApiResponse<>("Deleted Post Successfully", null, null);
        return ResponseEntity.ok(response);
    }

}
