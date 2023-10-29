package com.example.springsecurityjwt.security.services.impl;

import com.example.springsecurityjwt.security.domain.SessionUser;
import com.example.springsecurityjwt.security.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

import static com.example.springsecurityjwt.security.constants.JwtClaims.SCOPE;
import static java.time.temporal.ChronoUnit.HOURS;

@RequiredArgsConstructor
@Service
public class JwtTokenService implements TokenService {

    private final JwtEncoder encoder;

    @Override
    public String generateToken(SessionUser user) {
        String scope =
            user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        Instant now = Instant.now();
        var claims =
            JwtClaimsSet
                .builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, HOURS))
                .subject(user.username())
                .claim(SCOPE, scope)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
