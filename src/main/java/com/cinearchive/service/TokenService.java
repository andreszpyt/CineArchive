package com.cinearchive.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cinearchive.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class TokenService {

    @Value("${cinearchive.security.secret}")
    public String secret;
    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("UserId", user.getId())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Cine Archive")
                .sign(algorithm);
    }
}
