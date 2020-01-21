package com.jtl.microscape.orderservice.core.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @Builder.Default
    private List<MenuCategorie> menuCategories = new ArrayList<>();

    public void addToMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.setMenu(this);
        menuCategories.add(menuCategorie);
    }

    public void addAllToMenuCategories(List<MenuCategorie> menuCategories) {
        menuCategories.forEach(this::addToMenuCategories);
    }

    public void removeFromMenuCategories(MenuCategorie menuCategorie) {
        menuCategorie.setMenu(null);
        menuCategories.remove(menuCategorie);
    }

}
