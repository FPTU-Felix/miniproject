package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.PostRequest;
import com.miniproject.miniproject.DTO.PostResponse;
import com.miniproject.miniproject.Model.Post;
import com.miniproject.miniproject.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(int id) {
        Post p = postRepository.findById(id).orElse(null);
        return (p != null) ? mapToResponse(p) : null;
    }

    @Override
    public PostResponse addPost(PostRequest request) {
        Post p = mapToEntity(request);
        Post saved = postRepository.save(p);
        return mapToResponse(saved);
    }

    @Override
    public PostResponse updatePost(int id, PostRequest request) {
        if (postRepository.existsById(id)) {
            Post p = mapToEntity(request);
            p.setId(id);
            Post updated = postRepository.save(p);
            return mapToResponse(updated);
        }
        return null;
    }

    @Override
    public void deletePost(int id) {
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
        p.setUser_id(post.getUser().getId());
        return p;
    }

    private Post mapToEntity(PostRequest request) {
        Post p = new Post();
        p.setTitle(request.getTitle());
        p.setContent(request.getContent());
        p.setCreatedAt(request.getCreated_at());
        p.getUser().setId(request.getUser_id());
        return p;
    }
}
