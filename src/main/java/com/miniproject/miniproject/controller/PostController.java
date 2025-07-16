package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/social/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse>>> getAllPosts() {
        List<PostResponse> list = postService.getAllPosts();
        ApiResponse<List<PostResponse>> response = new ApiResponse<>("Successfully", list,null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> getPostById(@PathVariable String id) { //
        PostResponse postResponse = postService.getPostById(id);
        ApiResponse<PostResponse> response = new ApiResponse<>("Founded", postResponse, null);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse>> addPost(@RequestBody @Valid PostRequest request, Authentication authentication) {
        String user_id = authentication.getName();
        PostResponse postRes = postService.addPost(request, user_id);
        ApiResponse<PostResponse> apiResponse = new ApiResponse<>("Created Successfully", postRes, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> updatedPost(@RequestBody @Valid PostRequest request,@PathVariable String id){
        PostResponse responsePost = postService.updatePost(id, request);
        ApiResponse<PostResponse> response = new ApiResponse<>("Post Updated Successfully", responsePost, null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deletePost(@PathVariable String id, Authentication authentication){
        String current_user_id = authentication.getName();
        postService.deletePost(id, current_user_id);
        ApiResponse<?> response = new ApiResponse<>("Deleted Post Successfully", null, null);
        return ResponseEntity.ok(response);
    }
}
