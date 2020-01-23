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
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Menu menu;

    @NotBlank
    private String caption;

    @OneToMany(mappedBy = "menuCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<MenuItem> menuItems = new ArrayList<>();

    void addToMenuCategories(MenuItem menuItems) {
        menuItems.setMenuCategory(this);
        this.menuItems.add(menuItems);
    }

    void addAllToMenuCategories(List<MenuItem> menuItems) {
        menuItems.forEach(this::addToMenuCategories);
    }

    void removeFromMenuCategories(MenuItem menuItem) {
        menuItem.setMenuCategory(null);
        menuItems.remove(menuItem);
    }

}
