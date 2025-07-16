package com.miniproject.miniproject.security;

import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);//Dung UserService
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerUserDetails(user);
    }

    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        User user = userService.findById(id);//Dung UserService
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerUserDetails(user);
    }
}
