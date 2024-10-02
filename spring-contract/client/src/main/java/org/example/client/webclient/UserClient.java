package org.example.client.webclient;

import org.example.client.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class UserClient {
  private final WebClient webClient;

  public UserClient(WebClient.Builder builder) {
    this.webClient = builder
        .baseUrl("http://localhost:8080")
        .build();
  }

  public Mono<User> getUser(String id) {
    return webClient.get()
        .uri(uriBuilder ->
            uriBuilder.path("/users")
                .queryParam("id", "123")
                .build())
        .retrieve()
        .bodyToMono(User.class);
  }
}
