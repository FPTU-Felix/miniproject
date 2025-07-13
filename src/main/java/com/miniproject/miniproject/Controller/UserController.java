package com.miniproject.miniproject.Controller;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Service.UserService;

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
