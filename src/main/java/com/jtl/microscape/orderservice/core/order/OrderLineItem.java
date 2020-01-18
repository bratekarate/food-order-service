package com.jtl.microscape.orderservice.core.order;

import com.jtl.microscape.orderservice.core.restaurant.MenuItem;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@Data
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Order order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    @NotNull
    private Integer quantity;

}
