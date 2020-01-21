package com.jtl.microscape.orderservice.core.restaurant;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class RestaurantTestDataCreator {
    public Restaurant create() {
        Restaurant restaurant = Restaurant.builder()
                .name("Pizza Prego")
                .menu(Menu.builder()
                        .build())
                .build();

        Menu menu = restaurant.getMenu();
        menu.restaurant = restaurant;

        MenuCategorie pizzen = MenuCategorie.builder()
                .caption("Pizzen")
                .menu(menu)
                .build();

        List<MenuItem> menuItems = List.of(
                MenuItem.builder()
                        .name("Pizza Funghi")
                        .price(new BigDecimal("4.50"))
                        .build());
//
        pizzen.addAllToMenuCategories(menuItems);
        menu.addToMenuCategories(pizzen);

        return restaurant;
    }
}
