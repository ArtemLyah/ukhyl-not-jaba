package com.example.ukhyl.infrastructure.repositories;

import com.example.ukhyl.domain.models.User;
import com.example.ukhyl.domain.models.UserCredentials;
import com.example.ukhyl.domain.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
  private final Map<String, User> userPersistence;
  private final Map<String, UserCredentials> userCredentialsPersistence;
  
  UserRepositoryImpl () {
    this.userPersistence = new HashMap<>();
    this.userCredentialsPersistence = new HashMap<>();
  }
  
  @Override
  public void createUser(UserCredentials credentials, User user) {
    userPersistence.put(user.getId(), user);
    userCredentialsPersistence.put(credentials.getUserId(), credentials);
  }
  
  @Override
  public Optional<User> findByEmail(String email) {
    return userCredentialsPersistence.values().stream()
      .filter(credentials -> credentials.getEmail().equals(email))
      .findFirst()
      .map(credentials -> userPersistence.get(credentials.getUserId()));
  }
  
  @Override
  public Optional<User> findById(String id) {
    return Optional.ofNullable(userPersistence.get(id));
  }
  
  @Override
  public Optional<User> findByUsername(String username) {
    return userPersistence.values().stream()
      .filter(user -> user.getUsername().equals(username))
      .findFirst();
  }
  
  @Override
  public void updateUser(User user) {
    userPersistence.put(user.getId(), user);
  }
  
  @Override
  public void updateCredentials(UserCredentials credentials) {
    userCredentialsPersistence.put(credentials.getUserId(), credentials);
  }
  
  @Override
  public void deleteUser(String id) {
    userPersistence.remove(id);
    userCredentialsPersistence.remove(id);
  }
}
