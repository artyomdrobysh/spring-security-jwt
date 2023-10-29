package com.example.springsecurityjwt.configs;

import com.example.springsecurityjwt.configs.props.Certs;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

@Configuration
public class JwtConfig {

    private final JwtEncoder encoder;
    private final JwtDecoder decoder;

    public JwtConfig(Certs props) {
        encoder = new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(
            new RSAKey.Builder(props.publicKey())
                .privateKey(props.privateKey())
                .build())));
        decoder = NimbusJwtDecoder.withPublicKey(props.publicKey()).build();
    }

    @Bean
    public JwtEncoder encoder() {
        return encoder;
    }

    @Bean
    public JwtDecoder decoder() {
        return decoder;
    }
}
