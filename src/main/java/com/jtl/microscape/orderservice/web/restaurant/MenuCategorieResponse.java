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
public class MenuCategorieResponse {

    @NotBlank
    private final String caption;

    @NotEmpty
    @Valid
    @Builder.Default
    private final List<MenuItemResponse> menuItems = new ArrayList<>();

}
