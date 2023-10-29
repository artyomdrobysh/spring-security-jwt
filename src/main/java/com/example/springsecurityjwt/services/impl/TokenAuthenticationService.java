package com.example.springsecurityjwt.services.impl;

import com.example.springsecurityjwt.security.domain.SessionUser;
import com.example.springsecurityjwt.security.services.TokenService;
import com.example.springsecurityjwt.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenAuthenticationService implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public String authenticate(String username, String password) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        authentication = authenticationManager.authenticate(authentication);
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        return tokenService.generateToken(sessionUser);
    }
}
