package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.service.ReactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/social")
@RequiredArgsConstructor
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @GetMapping
    public ApiResponse<List<ReactionResponse>> getAllReaction() {
        return reactionService.getAllReactions();
    }

    @PostMapping("/comment/{commentId}/reactions")
    public ResponseEntity<ApiResponse<ReactionResponse>> reactionComment(@PathVariable String commentId, Authentication authentication, @RequestBody ReactionRequest request) {
        String user_id = authentication.getName();
        ReactionResponse newReaction = reactionService.reactionComment(commentId, user_id, request);
        ApiResponse<ReactionResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), newReaction, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/posts/{postId}/reaction")
    public ResponseEntity<ApiResponse<ReactionResponse>> reactionPost(@PathVariable String postId, Authentication authentication, @RequestBody @Valid ReactionRequest request) {
        String user_id = authentication.getName();
        ReactionResponse newReaction = reactionService.reactionPost(postId, user_id, request);
        ApiResponse<ReactionResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), newReaction, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
