package com.example.springsecurityjwt.configs.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "app.certs")
public record Certs(RSAPrivateKey privateKey,
                    RSAPublicKey publicKey) {
}
