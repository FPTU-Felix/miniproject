package com.miniproject.miniproject.service;

import java.util.List;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.model.Post;

public interface PostService {

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String id);

    PostResponse addPost(PostRequest request, String user_id);

    PostResponse updatePost(String postId, PostRequest request);

    void deletePost(String postId, String currentUserId);

    CommentResponse postNewComment(String postId, String userId, CommentRequest request);

    List<Post> searchPosts(String keyword);
}
