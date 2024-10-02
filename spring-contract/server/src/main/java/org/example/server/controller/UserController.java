package org.example.server.controller;

import org.example.server.dto.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping
  public UserResponse getUser(@RequestParam String id) {
    if ("123".equals(id))
      return new UserResponse("tu");
    return new UserResponse("unknown");
  }
}
