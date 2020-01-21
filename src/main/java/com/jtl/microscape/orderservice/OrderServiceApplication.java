package com.jtl.microscape.orderservice;

import com.jtl.microscape.orderservice.core.customer.Customer;
import com.jtl.microscape.orderservice.core.order.Order;
import com.jtl.microscape.orderservice.core.order.OrderLineItem;
import com.jtl.microscape.orderservice.core.order.OrderRepository;
import com.jtl.microscape.orderservice.core.restaurant.Menu;
import com.jtl.microscape.orderservice.core.restaurant.MenuCategorie;
import com.jtl.microscape.orderservice.core.restaurant.MenuItem;
import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class OrderServiceApplication {

    @PersistenceContext
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(OrderRepository orderRepository) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) {
                Restaurant restaurant = Restaurant.builder()
                        .name("Pizza Prego")
                        .menu(Menu.builder()
                                .build())
                        .build();

                restaurant.getMenu().setRestaurant(restaurant);

                entityManager.persist(restaurant);
                entityManager.persist(restaurant.getMenu());

                MenuCategorie pizzen = MenuCategorie.builder()
                        .caption("Pizzen")
                        .menu(restaurant.getMenu())
                        .build();

                entityManager.persist(pizzen);

                List<MenuItem> menuItems = List.of(
                        MenuItem.builder()
                                .name("Pizza Funghi")
                                .price(new BigDecimal("4.50"))
                                .build());

                pizzen.addAllToMenuCategories(menuItems);
                restaurant.getMenu().addToMenuCategories(pizzen);

                menuItems.forEach(entityManager::persist);

                entityManager.persist(restaurant);

                Customer c = Customer.builder()
                                .name("Hans")
                                .build();

                entityManager.persist(c);

                entityManager.detach(c);

                Order order = Order.builder()
                        .orderedBy(c)
                        .placedAt(Instant.now())
                        .restaurant(restaurant)
                        .build();

                order.addToOrderLineItems(OrderLineItem.builder()
                        .menuItem(pizzen.getMenuItems().get(0))
                        .quantity(2)
                        .build());

                orderRepository.save(order);

            }
        };

    }

    @Transactional
    public void doStuff() {

    }

}
