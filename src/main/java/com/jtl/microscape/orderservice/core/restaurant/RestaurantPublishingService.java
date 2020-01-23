package com.jtl.microscape.orderservice.core.restaurant;

import com.jtl.microscape.orderservice.messaging.RestaurantPublishingCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantPublishingService {

    private final RestaurantWriteRepository restaurantWriteRepository;

    public void publish(RestaurantPublishingCommand command) {
        restaurantWriteRepository.save(command.getRestaurant());
    }

}
