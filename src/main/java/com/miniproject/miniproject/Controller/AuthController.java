package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.Request.UserLoginRequest;
import com.miniproject.miniproject.DTO.Request.UserRegisterRequest;
import com.miniproject.miniproject.DTO.Response.AuthenticationResponse;
import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Repository.UserRepository;
import com.miniproject.miniproject.Security.JwtService;
import com.miniproject.miniproject.Service.AuthenticationService;
import com.miniproject.miniproject.Service.Email.EmailService;
import com.miniproject.miniproject.Service.OTP.OtpService;
import com.miniproject.miniproject.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/library/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final OtpService otpService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private  final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest request) {
        try {
            //1. Xác thực username & password bằng Spring Security
            AuthenticationResponse response = authenticationService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Credential");
        }
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        User u = userRepository.findByEmail(email);
        if (u == null) {
            return ResponseEntity.badRequest().body("Can't find any email");
        }
        String otp = otpService.generateOtp(email);
        emailService.sendOtp(email, otp);
        return ResponseEntity.ok("OTP send to Email");
    }


    @PostMapping("reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String otp, @RequestParam String newPassword) {
        if (!otpService.validateOtp(email, otp)) {
            return ResponseEntity.badRequest().body("Invalid or experied OTP");
        }
        if (userRepository.findByEmail(email) == null) {
            return ResponseEntity.badRequest().body("User not found!");
        }
        User u = userRepository.findByEmail(email);
        u.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(u);
        return ResponseEntity.ok("Reset Password successfully");
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest request) {
        User u = userService.register(request);
        return ResponseEntity.ok(u);
    }
}
