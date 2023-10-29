package com.example.springsecurityjwt.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredDataController {

    @GetMapping("/authenticated-users")
    public String getResourceAllowedAuthenticatedUsers() {
        return "allowed authenticated users";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority(T(com.example.springsecurityjwt.domain.enums.Role).ADMIN.name())")
    public String getResourceAllowedAdmins() {
        return "allowed admins";
    }
}
