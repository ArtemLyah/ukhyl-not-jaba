package com.example.ukhyl.domain.repositories;

import com.example.ukhyl.domain.models.User;
import com.example.ukhyl.domain.models.UserCredentials;

import java.util.Optional;

public interface UserRepository {
  void createUser(UserCredentials credentials, User user);
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
  Optional<User> findById(String id);
  void updateUser(User user);
  void updateCredentials(UserCredentials credentials);
  void deleteUser(String id);
}
