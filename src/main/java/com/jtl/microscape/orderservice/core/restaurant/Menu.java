package com.jtl.microscape.orderservice.core.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    // todo: does this work? Mapping to `MenuCategorie` although it is mapped to  `Restaurant` in `@ManyToOne` association?
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MenuCategorie> menuCategories = new ArrayList<>();

}
