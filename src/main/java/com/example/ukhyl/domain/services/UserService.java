package com.example.ukhyl.domain.services;

import com.example.ukhyl.common.exceptions.NotFoundException;
import com.example.ukhyl.domain.models.User;
import com.example.ukhyl.domain.models.UserCredentials;
import com.example.ukhyl.domain.repositories.UserRepository;
import com.example.ukhyl.domain.services.dto.UserCreateDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  
  public UserService(
    UserRepository userRepository,
    PasswordEncoder passwordEncoder
  ) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }
  
  public User createUser(UserCreateDTO dto) {
    String fullName = dto.getFirstName() + " " + dto.getLastName() + " " + dto.getSecondName();
    String password = passwordEncoder.encode(dto.getPassword());
    
    System.out.println(password);
    
    User user = User.create(dto.getUsername(), fullName, dto.getAvatarUrl());
    UserCredentials userCredentials = UserCredentials.create(dto.getEmail(), password);
    
    userRepository.createUser(userCredentials, user);
    
    return user;
  }
  
  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username).orElseThrow(NotFoundException::new);
  }
  
  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
  }
  
  public User getUserById(String id) {
    return userRepository.findById(id).orElseThrow(NotFoundException::new);
  }
}
