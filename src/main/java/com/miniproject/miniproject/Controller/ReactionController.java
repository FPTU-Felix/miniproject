package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.ReactionResponse;
import com.miniproject.miniproject.Service.ReactionService;
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
