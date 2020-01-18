package com.jtl.microscape.orderservice.core.order;

import com.jtl.microscape.orderservice.core.customer.Customer;
import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Instant placedAt;

    @NotNull
    @ManyToOne
    private Restaurant restaurant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer orderedBy;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

}
