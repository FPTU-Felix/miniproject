package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.Model.User;

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
