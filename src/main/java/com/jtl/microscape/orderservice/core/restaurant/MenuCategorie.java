package com.jtl.microscape.orderservice.core.restaurant;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuCategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    Menu menu;

    @NotBlank
    String caption;

    @OneToMany(mappedBy = "menuCategorie", fetch = FetchType.LAZY)
    @Builder.Default
    private List<MenuItem> menuItems = new ArrayList<>();

    void addToMenuCategories(MenuItem menuItems) {
        menuItems.menuCategorie = this;
        this.menuItems.add(menuItems);
    }

    void addAllToMenuCategories(List<MenuItem> menuItems) {
        menuItems.forEach(this::addToMenuCategories);
    }

    void removeFromMenuCategories(MenuItem menuItem) {
        menuItem.menuCategorie = null;
        menuItems.remove(menuItem);
    }

}
