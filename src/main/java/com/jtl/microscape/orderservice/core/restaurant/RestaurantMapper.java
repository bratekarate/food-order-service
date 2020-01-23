package com.jtl.microscape.orderservice.core.restaurant;

import com.jtl.microscape.orderservice.messaging.RestaurantMessage;
import org.springframework.stereotype.Component;

// todo: replace with mapstruct mapper
@Component
public class RestaurantMapper {

    public Restaurant mapToEntity(RestaurantMessage restaurantMessage) {
        // todo: replace dummy method
        return Restaurant.builder()
                .id(1L)
                .name("test")
                .build();
    }

}
