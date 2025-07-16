package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.UserLoginRequest;
import com.miniproject.miniproject.dto.Request.UserRegisterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.AuthenticationResponse;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.service.AuthenticationService;
import com.miniproject.miniproject.service.email.EmailService;
import com.miniproject.miniproject.service.otp.OtpService;
import com.miniproject.miniproject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final OtpService otpService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody @Valid UserLoginRequest request) {
        ApiResponse response = null;
        try {
            //1. Xác thực username & password bằng Spring Security
            response = authenticationService.login(request);
            return response;
        } catch (Exception e) {
            response.setStatus("Invalid Credential");
            return response;
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

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = otpService.validateOtp(email, otp);
        if (!valid) return ResponseEntity.badRequest().body("Invalid or experied OTP");
        return ResponseEntity.ok("OTP verifired!");
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
    public ApiResponse<User> register(@RequestBody @Valid UserRegisterRequest request) {
        try {
            User u = userService.register(request);
            return new ApiResponse<>("sucess", u, null);
        }catch (Exception e){
            return new ApiResponse<>("Fail", null, null);
        }
    }
}
