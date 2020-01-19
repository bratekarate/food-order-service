package com.jtl.microscape.orderservice.web.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@ToString
public class OrderRestaurantResponse {

    private final Long id;

    @NotBlank
    private final String name;

}
