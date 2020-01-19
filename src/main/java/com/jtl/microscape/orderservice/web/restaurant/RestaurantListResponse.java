package com.jtl.microscape.orderservice.web.restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@ToString
public class RestaurantListResponse {

    private final Long id;

    @NotNull
    private final String name;

}
