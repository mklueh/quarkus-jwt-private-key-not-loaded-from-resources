package com.example;

import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

@ApplicationScoped
public class JWTUtil {

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwt
                .claims(claims)
                .subject(subject)
                .issuer("http://localhost")
                .issuedAt(System.currentTimeMillis())
                .expiresAt(System.currentTimeMillis() + 1000 * 60 * 60 * 10)
                .sign();
    }

    public String createToken(Map<String, Object> claims, String subject, String privateKey) {

        return Jwt
                .claims(claims)
                .subject(subject)
                .issuer("http://localhost")
                .issuedAt(System.currentTimeMillis())
                .expiresAt(System.currentTimeMillis() + 1000 * 60 * 60 * 10)
                .sign(privateKey);
    }
}
