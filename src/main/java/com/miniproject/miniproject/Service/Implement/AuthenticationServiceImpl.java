package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.AuthenticationResponse;
import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Repository.UserRepository;
import com.miniproject.miniproject.Security.CustomerUserDetails;
import com.miniproject.miniproject.Security.JwtService;
import com.miniproject.miniproject.Service.AuthenticationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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
            return new ApiResponse("Sucess", authenticationResponse, null);
        } catch (Exception e) {
            System.out.println("❌ Token generation failed:");
            e.printStackTrace();
            throw new RuntimeException("Token generation failed: " + e.getMessage());
        }
    }

}
