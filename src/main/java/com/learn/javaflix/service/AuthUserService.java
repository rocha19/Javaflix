package com.learn.javaflix.service;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.learn.javaflix.models.User;
import com.learn.javaflix.repositories.UserRespository;

@Service
public class AuthUserService {
  @Value("${security.token.secret}")
  private String secretKey;

  @Autowired
  private UserRespository userRUserRespository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String perform(User user) throws AuthenticationException {
    var userResult = this.userRUserRespository.findByUsername(user.getUsername()).orElseThrow(() -> {
      throw new UsernameNotFoundException("username/password incorrect.");
    });

    var passwordMatches = this.passwordEncoder.matches(user.getPassword(), userResult.getPassword());

    if (!passwordMatches) {
      throw new AuthenticationException();
    }

    Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
    var token = JWT.create().withIssuer("javaflix").withExpiresAt(Instant.now().plus(Duration.ofHours(1))).withSubject(userResult.getUsername()).sign(algorithm);

    return token;
  }
}
