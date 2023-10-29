package com.example.springsecurityjwt.services;

public interface AuthenticationService {

    String authenticate(String username, String password);
}
