package com.miniproject.miniproject.Service;

import java.util.List;

import com.miniproject.miniproject.DTO.UserLoginRequest;
import com.miniproject.miniproject.DTO.UserRegisterRequest;
import com.miniproject.miniproject.Model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);

    User register(UserRegisterRequest request);

    User login(UserLoginRequest request);

    List<User> searchUsers(String keyword);
}
