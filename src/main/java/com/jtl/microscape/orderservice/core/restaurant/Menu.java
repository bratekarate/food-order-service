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
    private List<MenuCategorie> menuCategories = new ArrayList<>();

    void addToMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.setMenu(this);
        menuCategories.add(menuCategorie);
    }

    void addAllToMenuCategories(List<MenuCategorie> menuCategories) {
        menuCategories.forEach(this::addToMenuCategories);
    }

    void removeFromMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.setMenu(null);
        menuCategories.remove(menuCategorie);
    }

}
