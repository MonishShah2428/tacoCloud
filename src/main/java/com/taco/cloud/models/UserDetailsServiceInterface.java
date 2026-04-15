package com.taco.cloud.models;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsServiceInterface  {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
