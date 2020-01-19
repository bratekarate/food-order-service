package com.jtl.microscape.orderservice.web.restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class RestaurantController {

    @GetMapping("")
    public List<RestaurantListResponse> restaurants() {
        return List.of(RestaurantListResponse.builder()
                .id(1L)
                .name("Pizza Prego")
                .build());
    }

    @GetMapping("/{id}")
    public RestaurantResponse showRestaurant(@PathVariable("id") Long id) {
        return RestaurantResponse.builder()
                .id(id)
                .name("Pizza Prego")
                .menuCategories(List.of(
                        MenuCategorieResponse.builder()
                                .caption("Pizzen")
                                .menuItems(List.of(
                                        MenuItemResponse.builder()
                                                .id(1L)
                                                .name("Pizza Funghi")
                                                .price(new BigDecimal("4.50"))
                                                .build(),
                                        MenuItemResponse.builder()
                                                .id(2L)
                                                .name("Pizza Rucola")
                                                .price(new BigDecimal("7.50"))
                                                .build()
                                ))

                                .build()
                ))
                .build();
    }

}