package com.example.springsecurityjwt.security.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

import static com.example.springsecurityjwt.security.constants.JwtClaims.SCOPE;
import static java.util.Collections.emptyList;

@Component
public class JwtConverter implements Converter<Jwt, JwtAuthenticationToken> {

    @Override
    public JwtAuthenticationToken convert(Jwt source) {
        var scopeClaim = source.getClaims().get(SCOPE);
        Collection<? extends GrantedAuthority> authorities = scopeClaim instanceof String scope && !scope.isBlank()
            ? Arrays.stream(scope.split(" ")).map(SimpleGrantedAuthority::new).toList()
            : emptyList();
        return new JwtAuthenticationToken(source, authorities);
    }
}
