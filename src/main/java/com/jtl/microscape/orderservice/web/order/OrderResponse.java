package com.jtl.microscape.orderservice.web.order;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@ToString
public class OrderResponse {

    private final Long id;

    @NotNull
    private final Instant placedAt;

    @NotNull
    private RestaurantOrderResponse restaurant;

    @NotEmpty
    private final List<OrderLineItemResponse> orderLineItems;

}
