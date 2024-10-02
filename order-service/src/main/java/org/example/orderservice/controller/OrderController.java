package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.client.Notification;
import org.example.orderservice.client.NotificationClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
  private final NotificationClient notificationClient;

  @PostMapping
  public Mono<OrderRes> createOrder(@RequestBody OrderReq order) {
    log.info("Create order: {}", order);
    String orderId = UUID.randomUUID().toString();
    return notificationClient.notify(new Notification(order.userId(), orderId))
        .thenReturn(new OrderRes(orderId, order.productId(), order.quantity()));
  }

}
