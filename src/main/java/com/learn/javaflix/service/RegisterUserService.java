package com.learn.javaflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.javaflix.models.User;
import com.learn.javaflix.repositories.UserRespository;

@Service
public class RegisterUserService 
{
  @Autowired
  private UserRespository userRUserRespository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public boolean perform(User user) 
  {
    var password = passwordEncoder.encode(user.getPassword());
    user.setPassword(password);
    return this.userRUserRespository.save(user.getUsername(), user.getPassword());
  }
}
