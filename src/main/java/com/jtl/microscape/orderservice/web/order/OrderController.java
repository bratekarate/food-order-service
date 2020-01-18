package com.jtl.microscape.orderservice.web.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("")
    public List<OrderResponse> orders() {
        return List.of(
                OrderResponse.builder()
                        .id(1L)
                        .placedAt(Instant.now().minus(30, ChronoUnit.MINUTES))
                        .orderLineItems(List.of(
                                OrderLineItemResponse.builder()
                                        .id(1L)
                                        .menuItem(MenuItemResponse.builder()
                                                .id(1L)
                                                .name("Pizza Funghi")
                                                .price(new BigDecimal("4.50"))
                                                .build())
                                        .quantity(2)
                                        .build(),
                                OrderLineItemResponse.builder()
                                        .id(2L)
                                        .menuItem(MenuItemResponse.builder()
                                                .id(2L)
                                                .name("Pizza Verde")
                                                .price(new BigDecimal("7.00"))
                                                .build())
                                        .quantity(1)
                                        .build()))
                        .restaurant(RestaurantOrderResponse.builder()
                                .id(1L)
                                .name("Pizza Prego")
                                .build())
                        .build());
    }

    @PostMapping("")
    public OrderDto placeOrder(OrderDto orderDto) {
        return orderDto;
    }

}