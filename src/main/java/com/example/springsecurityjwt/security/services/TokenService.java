package com.example.springsecurityjwt.security.services;

import com.example.springsecurityjwt.security.domain.SessionUser;

public interface TokenService {

    String generateToken(SessionUser user);
}
