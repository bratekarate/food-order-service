package com.jtl.microscape.orderservice.core.restaurant;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @NotNull
    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY)
    Menu menu;

    static RestaurantBuilder builder() {
        return new RestaurantBuilder();
    }

}
