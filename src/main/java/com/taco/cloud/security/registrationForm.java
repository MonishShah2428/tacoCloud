package com.taco.cloud.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class registrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phoneNumber);
    }
}
