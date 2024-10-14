package com.example.ukhyl.application.controllers;

import com.example.ukhyl.domain.models.User;
import com.example.ukhyl.domain.models.UserCredentials;
import com.example.ukhyl.domain.services.UserService;
import com.example.ukhyl.domain.services.dto.UserCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  
  @PostMapping()
  User createUser (@RequestBody @Validated UserCreateDTO user) {
    return userService.createUser(user);
  }
  
  @GetMapping("/{id}")
  User getUser (@PathVariable String id) {
    return userService.getUserById(id);
  }
}
