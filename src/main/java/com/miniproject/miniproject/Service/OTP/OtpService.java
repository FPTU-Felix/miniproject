package com.miniproject.miniproject.Service.OTP;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final Cache<String, String> otpCache;//Guava Cache library -> Use to store short-term data
//Cache<String, String> based from Cache<Key, Value> => Key: email abd Value: Otp
    public String generateOtp(String email){
        String otp = String.valueOf(new Random().nextInt(899999)+100000);//6 digrit
        otpCache.put(email,otp);//save this otp in cache with email is a key( like hash map in Java)
        return otp;
    }

    public boolean validateOtp(String email, String inputOtp){
        String cachedOtp = otpCache.getIfPresent(email);//get it if it exist
        return inputOtp.equals(cachedOtp);
    }
}
