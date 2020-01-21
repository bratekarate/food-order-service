package com.jtl.microscape.orderservice.core.order;

import com.jtl.microscape.orderservice.core.customer.Customer;
import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_")
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
    @Builder.Default
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

    public void addToOrderLineItems(OrderLineItem orderLineItem) {
        orderLineItem.setOrder(this);
        this.orderLineItems.add(orderLineItem);
    }

    public void addAllToOrderLineItems(List<OrderLineItem> orderLineItems) {
        orderLineItems.forEach(this::addToOrderLineItems);
    }

    public void removeFromOrderLineItems(OrderLineItem orderLineItem) {
        orderLineItem.setOrder(null);
        this.orderLineItems.remove(orderLineItem);
    }

}
