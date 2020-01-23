package com.jtl.microscape.orderservice.messaging;

import com.jtl.microscape.orderservice.core.restaurant.RestaurantMapper;
import com.jtl.microscape.orderservice.core.restaurant.RestaurantPublishingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublishingService {

    private final RestaurantPublishingService restaurantPublishingService;
    private final RestaurantMapper restaurantMapper;

    // todo: implement as messaging listener
    public void publishRestaurant(RestaurantMessage message) {
        // todo: perform actual logic that makes sense
        restaurantPublishingService.publish(new RestaurantPublishingCommand(restaurantMapper.mapToEntity(message)));
    }

}
