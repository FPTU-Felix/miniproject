package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Response.AuthenticationResponse;
import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Repository.UserRepository;
import com.miniproject.miniproject.Security.CustomerUserDetails;
import com.miniproject.miniproject.Security.JwtService;
import com.miniproject.miniproject.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.channels.Channels;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public AuthenticationResponse login(UserLoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (AccountExpiredException e) {
            throw new RuntimeException("Invalid username or password");
        }
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) throw new RuntimeException("User not found!");
        UserDetails userDetails = new CustomerUserDetails(user);
        String jwt = jwtService.gennerateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }
}
