package com.jtl.microscape.orderservice.core.restaurant;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Menu {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @ToString.Exclude
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @Builder.Default
    private List<MenuCategory> menuCategories = new ArrayList<>();

    void addToMenuCategories(MenuCategory menuCategory) {
        menuCategory.setMenu(this);
        menuCategories.add(menuCategory);
    }

    void addAllToMenuCategories(List<MenuCategory> menuCategories) {
        menuCategories.forEach(this::addToMenuCategories);
    }

    void removeFromMenuCategories(MenuCategory menuCategory) {
        menuCategory.setMenu(null);
        menuCategories.remove(menuCategory);
    }

}
