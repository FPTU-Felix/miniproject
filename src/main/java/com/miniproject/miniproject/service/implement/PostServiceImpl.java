package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.exception.AccessDeniedException;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.PostRepository;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    //    @Autowired
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find Post with id =" + id));
        return mapToResponse(post);
    }

    @Override
    public PostResponse addPost(PostRequest request, String user_id) {
        User u = (User) userRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        Post p = mapToEntity(request);
        p.setUser(u);
        Post saved = postRepository.save(p);
        return mapToResponse(saved);
    }

    @Override
    public PostResponse updatePost(String post_id, PostRequest request) {
        if (postRepository.existsById(post_id)) {
            Post p = mapToEntity(request);
            Post updated = postRepository.save(p);
            return mapToResponse(updated);
        } else throw new ResourceNotFoundException("Post not found!");
    }

    @Override
    public void deletePost(String post_id, String current_user_id) {//Sau cần nâng cấp khi có @Perauthorize
        Post post = postRepository.findById(post_id).orElseThrow(() -> new ResourceNotFoundException("Post not found!"));
        if (!post.getUser().getId().equals(current_user_id)) {
            throw new AccessDeniedException("You don't have permission to delete this Post");
        }
        postRepository.deleteById(post_id);
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
        p.setUpdated_at(post.getUpdatedAt());
        p.setPosted_by(post.getUser().getId());
        return p;
    }

    private Post mapToEntity(PostRequest request) {
        Post p = new Post();
        p.setTitle(request.getTitle());
        p.setContent(request.getContent());
        return p;
    }
}
