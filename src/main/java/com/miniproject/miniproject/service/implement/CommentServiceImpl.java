package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;
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
import com.miniproject.miniproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentResponse> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getCommentsByPostID(String postId) {
        List<Comments> list = commentRepository.findCommentsByPostId(postId);
        if (!list.isEmpty()) {
            return list.stream().map(this::mapToResponse).collect(Collectors.toList());
        } else throw new ResourceNotFoundException("Comment Not Found!");
    }

    @Override
    public CommentResponse updateComment(String commentId, CommentRequest request) {
        if(commentRepository.existsById(commentId)){
            Comments c = mapToEntity(request);
            Comments updated = commentRepository.save(c);
            return mapToResponse(updated);
        }else throw new ResourceNotFoundException("Can't found comment!");
    }

    @Override
    public void deleteComment(String commentId, String currentUserId) {
        Comments c = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Can't found comment!"));
        if(!c.getUser().getId().equals(currentUserId)){
            throw new AccessDeniedException("You don't have permission to edit this!");
        }
        commentRepository.deleteById(commentId);
    }

    @Override
    public CommentResponse replyComment(String userId, String parentCommentId, CommentRequest request) {
        Comments parentComment = commentRepository.findById(parentCommentId).orElseThrow(() -> new ResourceNotFoundException("Can't found comment!"));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Can't found User!"));
        Comments replyComment = new Comments();
        replyComment.setContent(request.getContent());
        replyComment.setUser(user);
        replyComment.setRepliedTo(parentComment);
        replyComment.setPost(parentComment.getPost());
        Comments saved = commentRepository.save(replyComment);
        return mapToResponse(saved);
    }

    private CommentResponse mapToResponse(Comments comments) {
        CommentResponse b = new CommentResponse();
        b.setContent(comments.getContent());
        b.setCreated_at(comments.getCreatedAt());
        b.setUpdated_at(comments.getUpdatedAt());
        return b;
    }

    //maping entity
    private Comments mapToEntity(CommentRequest request) {
        Comments b = new Comments();
        b.setContent(request.getContent());
        return b;
    }
}
