package com.miniproject.miniproject.Controller;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest request){
        User u = userService.register(request);
        return ResponseEntity.ok(u);
    }
}
