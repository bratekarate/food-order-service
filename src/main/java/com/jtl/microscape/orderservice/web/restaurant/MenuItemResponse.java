package com.jtl.microscape.orderservice.web.restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
@ToString
public class MenuItemResponse {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

}
