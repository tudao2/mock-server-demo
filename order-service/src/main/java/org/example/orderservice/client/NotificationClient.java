package org.example.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NotificationClient {
  private final WebClient webClient;

  public NotificationClient(WebClient.Builder webClient) {
    this.webClient = webClient
        .baseUrl("http://localhost:9000")
        .build();
  }

  public Mono<String> notify(Notification notification) {
    return webClient.post()
        .uri("/notification")
        .bodyValue(notification)
        .retrieve()
        .bodyToMono(String.class);
  }
}
