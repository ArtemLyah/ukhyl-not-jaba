package com.example.ukhyl.domain.services.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@JsonTypeName("user")
@Value
public class UserCreateDTO {
  @Email
  String email;

  @Length(min = 8, max = 32)
  String password;
  
  @Length(min = 6, max = 20)
  String username;
  
  String firstName;
  
  String lastName;
  
  String secondName;
  
  @URL
  String avatarUrl;
}
