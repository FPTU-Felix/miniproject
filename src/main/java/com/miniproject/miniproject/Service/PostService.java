package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.PostRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.PostResponse;
import com.miniproject.miniproject.Model.Post;

public interface PostService {

    ApiResponse<List<PostResponse>> getAllPosts();

    ApiResponse<PostResponse> getPostById(String id);

    ApiResponse<PostResponse> addPost(PostRequest request);

//    PostResponse updatePost(int id, PostRequest request);

    void deletePost(String id);

    List<Post> searchPosts(String keyword);
}
