package com.jtl.microscape.orderservice.web.order;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class OrderLineItemResponse {

    private final Long id;

    @NotNull
    private final MenuItemResponse menuItem;

    @NotNull
    private final Integer quantity;

}
