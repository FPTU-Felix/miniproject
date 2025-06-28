package com.miniproject.miniproject.Controller;

import com.miniproject.miniproject.DTO.UserLoginRequest;
import com.miniproject.miniproject.Model.User;
import com.miniproject.miniproject.Repository.UserRepository;
import com.miniproject.miniproject.Service.Email.EmailService;
import com.miniproject.miniproject.Service.OTP.OtpService;
import com.miniproject.miniproject.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/library/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final OtpService otpService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest request){
        User u = userService.login(request);
        return ResponseEntity.ok(u);
    }
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email){
        User u = userRepository.findByEmail(email);
        if (u==null){
            return ResponseEntity.badRequest().body("Can't find any email");
        }
        String otp = otpService.generateOtp(email);
        emailService.sendOtp(email,otp);
        return ResponseEntity.ok("OTP send to Email");
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp){
        boolean valid = otpService.validateOtp(email,otp);
        if(!valid) return ResponseEntity.badRequest().body("Invalid or experied OTP");
        return ResponseEntity.ok("OTP verifired!");
    }
    @PostMapping("reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String otp, @RequestParam String newPassword){
        if (!otpService.validateOtp(email, otp)){
            return ResponseEntity.badRequest().body("Invalid or experied OTP");
        }
        if (userRepository.findByEmail(email)==null){
            return ResponseEntity.badRequest().body("User not found!");
        }
        User u = userRepository.findByEmail(email);
        u.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(u);
        return ResponseEntity.ok("Reset Password successfully");
    }
}
