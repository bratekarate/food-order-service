package com.jtl.microscape.orderservice.core.order;

import com.jtl.microscape.orderservice.core.restaurant.MenuItem;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @ToString.Exclude
    private Order order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    @NotNull
    private Integer quantity;

}
