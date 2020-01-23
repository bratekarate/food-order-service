package com.jtl.microscape.orderservice.messaging;

import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class RestaurantPublishingCommand {
    private final Restaurant restaurant;
}
