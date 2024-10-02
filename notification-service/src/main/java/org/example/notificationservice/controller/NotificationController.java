package org.example.notificationservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/notification")
@RestController
@Slf4j
public class NotificationController {

  @PostMapping
  public Mono<String> sendNotification(@RequestBody Notification notification) {
    log.info("Notification - User: {} - Created order: {}", notification.userId(), notification.orderId());
    return Mono.just("success");
  }
}
