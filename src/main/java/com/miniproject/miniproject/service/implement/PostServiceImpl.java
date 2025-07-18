package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.PostRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.exception.AccessDeniedException;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Comments;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.Reaction;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.CommentRepository;
import com.miniproject.miniproject.repository.PostRepository;
import com.miniproject.miniproject.repository.ReactionRepository;
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
    private final CommentRepository commentRepository;
    private final ReactionRepository reactionRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository, ReactionRepository reactionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.reactionRepository = reactionRepository;
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
    public PostResponse addPost(PostRequest request, String userId) {
        User u = (User) userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        Post p = mapToEntity(request);
        p.setUser(u);
        Post saved = postRepository.save(p);
        return mapToResponse(saved);
    }

    @Override
    public PostResponse updatePost(String postId, PostRequest request) {
        if (postRepository.existsById(postId)) {
            Post p = mapToEntity(request);
            Post updated = postRepository.save(p);
            return mapToResponse(updated);
        } else throw new ResourceNotFoundException("Post not found!");
    }

    @Override
    public void deletePost(String postId, String currentUserId) {//Sau cần nâng cấp khi có @Perauthorize
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found!"));
        if (!post.getUser().getId().equals(currentUserId)) {
            throw new AccessDeniedException("You don't have permission to delete this Post");
        }
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }

    @Override
    public CommentResponse postNewComment(String postId, String userId, CommentRequest request) {
        Post p = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found!"));
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        Comments newComment = new Comments();
        newComment.setContent(request.getContent());
        newComment.setPost(p);
        newComment.setUser(u);
        Comments savedComment = commentRepository.save(newComment);
        return mapToCommentResponse(savedComment);
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

    private CommentResponse mapToCommentResponse(Comments comments) {
        CommentResponse b = new CommentResponse();
        b.setContent(comments.getContent());
        b.setCreated_at(comments.getCreatedAt());
        b.setUpdated_at(comments.getUpdatedAt());
        return b;
    }
    private ReactionResponse mapToReactionResponse(Reaction reaction) {
        ReactionResponse b = new ReactionResponse();
        b.setType(reaction.getType());
        b.setCreated_at(reaction.getCreatedAt());
        b.setUpdated_at(reaction.getUpdatedAt());
        return b;
    }
}
