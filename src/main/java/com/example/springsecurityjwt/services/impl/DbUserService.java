package com.example.springsecurityjwt.services.impl;

import com.example.springsecurityjwt.persistence.repositories.UserRepository;
import com.example.springsecurityjwt.security.domain.SessionUser;
import com.example.springsecurityjwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DbUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
            .findByUsername(username)
            .map(SessionUser::new)
            .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}
