package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.CommentResponse;
import com.miniproject.miniproject.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/social/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ApiResponse<List<CommentResponse>> getAllComment(){
        return commentService.getAllComments();
    }
}
