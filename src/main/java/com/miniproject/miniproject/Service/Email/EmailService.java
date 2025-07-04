package com.miniproject.miniproject.Service.Email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender; //Inject JavaMailSender ( 1 bean in Java)

    public void sendOtp(String to, String otp) {
        SimpleMailMessage mess = new SimpleMailMessage();
        String subject = "Reset Password OTP";
        String content = String.format("""
                Dear user,
                
                You have requested to reset your password.
                
                Your OTP code is: %s
                
                Please do not share this code with anyone. It is valid for 5 minutes.
                
                Regards,
                Luong Gia Tung
                """, otp);
        mess.setTo(to); // Set recived email(user email)
        mess.setSubject(subject); //header of email
        mess.setText(content);//context of email

        mailSender.send(mess);//send email by emailSender(Bean under Spring control)
    }
}
