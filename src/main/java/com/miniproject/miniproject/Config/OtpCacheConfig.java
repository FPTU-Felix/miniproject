package com.miniproject.miniproject.Config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
@Configuration
public class OtpCacheConfig {
    @Bean

    public Cache<String, String> otpCache() {
        return Caffeine.newBuilder().
                expireAfterWrite(5, TimeUnit.MINUTES)//expired after 5 minutes
                .maximumSize(1000)
                .build();
    }
}
