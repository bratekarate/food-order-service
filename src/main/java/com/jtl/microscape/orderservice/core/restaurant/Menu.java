package com.jtl.microscape.orderservice.core.restaurant;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Menu {

    @Id
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    Restaurant restaurant;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @Builder.Default
    List<MenuCategorie> menuCategories = new ArrayList<>();

    void addToMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.menu = this;
        menuCategories.add(menuCategorie);
    }

    void addAllToMenuCategories(List<MenuCategorie> menuCategories) {
        menuCategories.forEach(this::addToMenuCategories);
    }

    void removeFromMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.menu = null;
        menuCategories.remove(menuCategorie);
    }

}
