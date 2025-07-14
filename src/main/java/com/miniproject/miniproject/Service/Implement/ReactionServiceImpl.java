package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.CommentRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.CommentResponse;
import com.miniproject.miniproject.DTO.Response.ReactionResponse;
import com.miniproject.miniproject.Model.Comments;
import com.miniproject.miniproject.Model.Reaction;
import com.miniproject.miniproject.Repository.ReactionRepository;
import com.miniproject.miniproject.Service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReactionServiceImpl implements ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public ApiResponse<List<ReactionResponse>> getAllReactions() {
        List<ReactionResponse> reactionResponses = reactionRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), reactionResponses, null);
    }

    private ReactionResponse mapToResponse(Reaction reaction) {
        ReactionResponse b = new ReactionResponse();
        b.setType(reaction.getType());
        b.setCreated_at(reaction.getCreatedAt());
        b.setUpdated_at(reaction.getUpdatedAt());
        return b;
    }

    //maping entity
    private Comments mapToEntity(CommentRequest request) {
        Comments b = new Comments();
        b.setContent(request.getContent());
        b.setCreatedAt(request.getCreated_at());
        b.setUpdatedAt(request.getUpdated_at());
        return b;
    }

}
