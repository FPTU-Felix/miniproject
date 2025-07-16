package com.miniproject.miniproject.service;

import java.util.List;

import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.model.Post;

public interface PostService {

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String id);

    PostResponse addPost(PostRequest request, String user_id);

    PostResponse updatePost(String post_id, PostRequest request);

    void deletePost(String post_id, String current_user_id);

    List<Post> searchPosts(String keyword);
}
