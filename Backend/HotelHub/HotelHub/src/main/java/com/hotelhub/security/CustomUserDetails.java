package com.hotelhub.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hotelhub.entity.User;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a list of granted authorities
        return List.of();
    }

    @Override
    public String getPassword() {
        // Return the user's password
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Return the user's username (email or username)
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement logic based on your User entity, returning true for now
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement logic based on your User entity, returning true for now
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement logic based on your User entity, returning true for now
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement logic based on your User entity, returning true for now
        return true;
    }
}
