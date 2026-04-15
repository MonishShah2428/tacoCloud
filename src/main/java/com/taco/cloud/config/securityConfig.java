package com.taco.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.taco.cloud.repository.userRepositoryInterface;
import com.taco.cloud.models.User;

@Configuration
public class securityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(userRepositoryInterface userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if(user!=null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }
}
