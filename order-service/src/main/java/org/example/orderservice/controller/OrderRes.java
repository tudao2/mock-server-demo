package org.example.orderservice.controller;

public record OrderRes(String orderId, String productId, int quantity) { }
