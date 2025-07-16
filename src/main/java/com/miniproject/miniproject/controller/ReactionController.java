package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/social/reaction")
@RequiredArgsConstructor
public class ReactionController {
    @Autowired
    private ReactionService reactionService;
    @GetMapping
    public ApiResponse<List<ReactionResponse>> getAllReaction(){
        return reactionService.getAllReactions();
    }
}
