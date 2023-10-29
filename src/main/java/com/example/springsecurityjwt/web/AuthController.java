package com.example.springsecurityjwt.web;

import com.example.springsecurityjwt.dto.AuthData;
import com.example.springsecurityjwt.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-in")
    public String signIn(@RequestBody AuthData authData) {
        return authenticationService.authenticate(authData.username(), authData.password());
    }
}
