package com.miniproject.miniproject.service;

import java.util.List;

import com.miniproject.miniproject.dto.Request.UserRegisterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.model.User;

public interface UserService {

    ApiResponse<List<User>> getAllUsers();

    User getUserById(String id);

    User addUser(User user);

//    User updateUser(int id, User user);

    void deleteUser(String id);

    User register(UserRegisterRequest request);

    List<User> searchUsers(String keyword);

    User getCurrentUserInfo();

    User findByUsername(String username);
    User findById(String id);
}
