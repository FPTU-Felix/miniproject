package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.UserLoginRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.AuthenticationResponse;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.security.CustomerUserDetails;
import com.miniproject.miniproject.security.JwtService;
import com.miniproject.miniproject.service.AuthenticationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public ApiResponse login(UserLoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid username or password");
        }

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(EntityNotFoundException::new);
        UserDetails userDetails = new CustomerUserDetails(user);

        try {
            String jwt = jwtService.gennerateToken(userDetails);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt,user.getUsername(),user.getFullName(),user.getEmail(), user.getAvatar(),user.getRoles());
            return new ApiResponse(String.valueOf(HttpStatus.OK), authenticationResponse, null);
        } catch (Exception e) {
            System.out.println("❌ Token generation failed:");
            e.printStackTrace();
            throw new RuntimeException("Token generation failed: " + e.getMessage());
        }
    }

}
