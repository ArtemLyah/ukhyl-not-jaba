package com.example.ukhyl.domain.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Data
@Getter
public class UserCredentials {
          private String userId;
          private String email;
  @Setter private String password;
          private Date createdAt;
  @Setter private Date updatedAt;
  
  public UserCredentials(String userId, String email, String password, Date createdAt, Date updatedAt) {
    this.userId = Objects.requireNonNull(userId);
    this.email = Objects.requireNonNull(email);
    this.password = Objects.requireNonNull(password);
    this.createdAt = Objects.requireNonNull(createdAt);
    this.updatedAt = Objects.requireNonNull(updatedAt);
  }
  
  public static UserCredentials create (String email, String password) {
    String id = UUID.randomUUID().toString();
    Date createdAt = new Date();
    Date updatedAt = new Date();
    
    return new UserCredentials(id, email, password, createdAt, updatedAt);
  }
}
