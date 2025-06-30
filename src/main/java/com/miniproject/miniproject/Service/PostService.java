package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.PostRequest;
import com.miniproject.miniproject.DTO.Response.PostResponse;
import com.miniproject.miniproject.Model.Post;

public interface PostService {

    List<PostResponse> getAllPosts();

    PostResponse getPostById(int id);

    PostResponse addPost(PostRequest request);

    PostResponse updatePost(int id, PostRequest request);

    void deletePost(int id);

    List<Post> searchPosts(String keyword);
}
