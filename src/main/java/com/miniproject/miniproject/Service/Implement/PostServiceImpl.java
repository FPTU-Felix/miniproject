package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.PostRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.PostResponse;
import com.miniproject.miniproject.Model.Post;
import com.miniproject.miniproject.Repository.PostRepository;
import com.miniproject.miniproject.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public ApiResponse<List<PostResponse>> getAllPosts() {
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), postRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList()), null);
    }

    @Override
    public ApiResponse<PostResponse> getPostById(String id) {
        Post p = postRepository.findById(id).orElse(null);
        return (p != null) ? new ApiResponse<>(String.valueOf(HttpStatus.OK), mapToResponse(p), null) : new ApiResponse<>(String.valueOf(HttpStatus.NOT_FOUND), mapToResponse(p), null);
    }

    @Override
    public ApiResponse<PostResponse> addPost(PostRequest request) {
        Post p = mapToEntity(request);
        Post saved = postRepository.save(p);
        return new ApiResponse<>("Sucess", mapToResponse(saved), null);
    }

//    @Override
//    public PostResponse updatePost(int id, PostRequest request) {
//        if (postRepository.existsById(id)) {
//            Post p = mapToEntity(request);
//            p.setId(id);
//            Post updated = postRepository.save(p);
//            return mapToResponse(updated);
//        }
//        return null;
//    }

    @Override
    public void deletePost(String id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        }
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }

    private PostResponse mapToResponse(Post post) {
        PostResponse p = new PostResponse();
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setCreated_at(post.getCreatedAt());
        p.setPosted_by(post.getUser().getId());
        return p;
    }

    private Post mapToEntity(PostRequest request) {
        Post p = new Post();
        p.setTitle(request.getTitle());
        p.setContent(request.getContent());
        p.setCreatedAt(request.getCreated_at());
        p.getUser().setId(request.getPosted_by());
        return p;
    }
}
