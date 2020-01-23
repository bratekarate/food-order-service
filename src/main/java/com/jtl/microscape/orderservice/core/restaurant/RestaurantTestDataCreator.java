package com.jtl.microscape.orderservice.core.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantTestDataCreator {

    private final RestaurantWriteRepository restaurantWriteRepository;
    private final MenuCategoryWriteRepository menuCategoryWriteRepository;

    public Restaurant create() {
        Restaurant restaurant = Restaurant.builder()
                .name("Pizza Prego")
                .menu(Menu.builder()
                        .build())
                .build();

        Menu menu = restaurant.getMenu();
        menu.setRestaurant(restaurant);

        MenuCategory pizzen = MenuCategory.builder()
                .caption("Pizzen")
                .menu(menu)
                .build();

        List<MenuItem> menuItems = List.of(
                MenuItem.builder()
                        .name("Pizza Funghi")
                        .price(new BigDecimal("4.50"))
                        .build());

        pizzen.addAllToMenuCategories(menuItems);
        menu.addToMenuCategories(pizzen);

        restaurantWriteRepository.save(restaurant);

        List<MenuCategory> menuCategories = restaurant.getMenu().getMenuCategories();
        menuCategoryWriteRepository.saveAll(menuCategories);

        restaurantWriteRepository.save(restaurant);

        return restaurant;
    }
}
