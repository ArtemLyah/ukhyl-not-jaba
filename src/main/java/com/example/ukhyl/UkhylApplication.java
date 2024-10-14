package com.example.ukhyl;

import com.example.ukhyl.domain.services.UserService;
import com.example.ukhyl.infrastructure.repositories.UserRepositoryImpl;
import com.example.ukhyl.infrastructure.security.PasswordEncoderImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
  exclude = { SecurityAutoConfiguration.class }
)
public class UkhylApplication {
  public static void main(String[] args) {
    SpringApplication.run(UkhylApplication.class, args);
  }
  
  @Bean
  UserService userService(
    @Qualifier("userRepositoryImpl") UserRepositoryImpl userRepository,
    @Qualifier("passwordEncoderImpl") PasswordEncoderImpl passwordEncoder
    ) {
    return new UserService(userRepository, passwordEncoder);
  }
}
