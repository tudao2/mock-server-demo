package org.example.orderservice.controller;

public record OrderReq(String userId, String productId, int quantity) { }
