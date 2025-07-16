package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.model.Comments;
import com.miniproject.miniproject.repository.CommentRepository;
import com.miniproject.miniproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ApiResponse<List<CommentResponse>> getAllComments() {
        List<CommentResponse> commentResponses = commentRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), commentResponses, null);
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
