package com.miniproject.miniproject.Service.Implement;

import java.util.List;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.Model.Role;
import com.miniproject.miniproject.Repository.RoleRepository;
import com.miniproject.miniproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ApiResponse<List<User>> getAllUsers() {
        return new ApiResponse<>("Sucess", userRepository.findAll(), null);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

//    @Override
//    public User updateUser(int id, User user) {
//        if (userRepository.existsById(id)) {
//            user.setId(id);
//            return userRepository.save(user);
//        }
//        return null;
//    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUsers(String keyword) {
        // Implement search logic here if needed
        return null; // Placeholder for search implementation
    }

    @Override
    public User register(UserRegisterRequest request) {
        User u = new User();
        u.setUsername(request.getUsername());
        u.setPassword(passwordEncoder.encode(request.getPassword()));
        u.setFullName(request.getFullName());
        u.setEmail(request.getEmail());

        Role defaultRole = roleRepository.findByName("USER");
        if (defaultRole == null) {
            throw new RuntimeException("Default role not found");
        }
        u.setRoles(List.of(defaultRole));
        return userRepository.save(u);
    }

    //    @Override
//    public User login(UserLoginRequest request) {
//        User u = userRepository.findByUsername(request.getUsername());
//        if (u == null) {
//            throw new RuntimeException("User not found");
//        }
//        if (!passwordEncoder.matches(request.getPassword(), u.getPassword())) {
//            throw new RuntimeException("Invalid Password");
//        }
//        return u;
//    }
    @Override
    public User findByUsername(String username) {
        User u = userRepository.findByUsername(username);
        if (u == null) {
            return null;
        }
        return u;
    }

    @Override
    public User findById(String id) {
        User u = userRepository.findById(id);
        if (u == null) {
            return null;
        }
        return u;
    }
}
