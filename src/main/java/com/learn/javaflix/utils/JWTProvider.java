package com.learn.javaflix.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTProvider 
{
  @Value("${security.token.secret}")
  private String secretKay;
  
  public String perform(String token) 
  {
    token = token.replace("Bearer ", "");

    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKay);
      var subject = JWT.require(algorithm).build().verify(token).getSubject();
      
      return subject;
    } catch (JWTVerificationException exception) {
      exception.printStackTrace();
      return "";
    }
  }
}
