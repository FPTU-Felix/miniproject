package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
import com.miniproject.miniproject.Model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);

//    User updateUser(int id, User user);

    void deleteUser(int id);

    User register(UserRegisterRequest request);

    List<User> searchUsers(String keyword);

    User findByUsername(String username);
    User findById(String id);
}
