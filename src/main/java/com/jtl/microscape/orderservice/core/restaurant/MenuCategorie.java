package com.jtl.microscape.orderservice.core.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @NotBlank
    private String caption;

    @OneToMany(mappedBy = "menuCategorie", fetch = FetchType.LAZY)
    @Builder.Default
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addToMenuCategories(MenuItem menuItems) {
        menuItems.setMenuCategorie(this);
        this.menuItems.add(menuItems);
    }

    public void addAllToMenuCategories(List<MenuItem> menuItems) {
        menuItems.forEach(this::addToMenuCategories);
    }

    public void removeFromMenuCategories(MenuItem menuItem) {
        menuItem.setMenuCategorie(null);
        menuItems.remove(menuItem);
    }

}
