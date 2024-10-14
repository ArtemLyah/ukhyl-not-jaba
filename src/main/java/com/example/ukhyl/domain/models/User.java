package com.example.ukhyl.domain.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Data
@Getter
public class User {
          private String id;
  @Setter private String fullName;
  @Setter private String username;
  @Setter private String avatarUrl;
          private Date createdAt;
  @Setter private Date updatedAt;
  
  public User (
    String id,
    String username,
    String fullName,
    String avatarUrl,
    Date createdAt,
    Date updatedAt
  ) {
    this.id = Objects.requireNonNull(id);
    this.username = Objects.requireNonNull(username);
    this.fullName = Objects.requireNonNull(fullName);
    this.avatarUrl = Objects.requireNonNull(avatarUrl);
    this.createdAt = Objects.requireNonNull(createdAt);
    this.updatedAt = Objects.requireNonNull(updatedAt);
  }
  
  public static User create (String username, String fullName, String avatarUrl) {
    String id = UUID.randomUUID().toString();
    Date createdAt = new Date();
    Date updatedAt = new Date();
    
    return new User(id, username, fullName, avatarUrl, createdAt, updatedAt);
  }
}