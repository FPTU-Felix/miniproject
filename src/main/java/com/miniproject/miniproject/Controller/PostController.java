package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.PostResponse;
import com.miniproject.miniproject.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable int id) { //
        PostResponse p = postService.getPostById(id);
        if (p != null) {
            return p; // 200 OK
        } else {
            return null; // 404 Not Found
        }
    }
}
