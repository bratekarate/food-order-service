package com.jtl.microscape.orderservice.web.order;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;

@Builder
@Getter
@ToString
public class OrderLineItemResponse {

    private final Long id;

    @NotNull
    @Valid
    private final OrderMenuItemResponse menuItem;

    @NotNull
    private final Integer quantity;

}
