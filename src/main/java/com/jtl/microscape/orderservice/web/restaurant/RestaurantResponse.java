package com.jtl.microscape.orderservice.web.restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@ToString
public class RestaurantResponse {

    private final Long id;

    @NotBlank
    private final String name;

    @NotEmpty
    @Valid
    @Builder.Default
    private final List<MenuCategorieResponse> menuCategories = new ArrayList<>();

}
