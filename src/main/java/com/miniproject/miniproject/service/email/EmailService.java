package com.miniproject.miniproject.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender; //Inject JavaMailSender ( 1 bean in Java)

    public void sendOtp(String to, String otp){
        SimpleMailMessage mess = new SimpleMailMessage();
        mess.setTo(to); // Set recived email(user email)
        mess.setSubject("Reset Password OTP"); //header of email
        mess.setText("Your OTP code is:" + otp);//context of email
        mailSender.send(mess);//send email by emailSender(Bean under Spring control)
    }
}
