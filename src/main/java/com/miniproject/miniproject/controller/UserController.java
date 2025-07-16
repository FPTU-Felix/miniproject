package com.miniproject.miniproject.controller;

import java.util.List;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.service.UserService;

@RestController
@RequestMapping("/api/v1/library/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getCurrentUserInfo")
    public User getCurrentUserInfo(){
        return userService.getCurrentUserInfo();
    }
}
