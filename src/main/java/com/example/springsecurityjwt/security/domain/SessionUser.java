package com.example.springsecurityjwt.security.domain;

import com.example.springsecurityjwt.domain.enums.Role;
import com.example.springsecurityjwt.persistence.entities.User;
import com.example.springsecurityjwt.persistence.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public record SessionUser(String username,
                          String passwordHash,
                          boolean enabled,
                          List<? extends GrantedAuthority> authorities) implements UserDetails {

    public SessionUser(User user) {
        this(user.getUsername(), user.getPasswordHash(), user.isEnabled(),
            user
                .getRoles()
                .stream()
                .map(UserRole::getRole)
                .map(Role::name)
                .map(SimpleGrantedAuthority::new)
                .toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
