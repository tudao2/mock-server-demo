package org.example.client.service;

import lombok.RequiredArgsConstructor;
import org.example.client.domain.User;
import org.example.client.webclient.UserClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserClient userClient;

  public Mono<User> getUserById(String id) {
    return userClient.getUser(id);
  }
}
