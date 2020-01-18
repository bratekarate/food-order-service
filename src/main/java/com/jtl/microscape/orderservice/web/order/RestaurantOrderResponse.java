package com.jtl.microscape.orderservice.web.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@ToString
public class RestaurantOrderResponse {
    private Long id;

    @NotBlank
    private String name;
}
