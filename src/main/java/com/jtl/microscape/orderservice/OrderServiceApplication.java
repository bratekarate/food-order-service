package com.jtl.microscape.orderservice;

import com.jtl.microscape.orderservice.core.customer.Customer;
import com.jtl.microscape.orderservice.core.customer.CustomerTestDataCreator;
import com.jtl.microscape.orderservice.core.order.Order;
import com.jtl.microscape.orderservice.core.order.OrderLineItem;
import com.jtl.microscape.orderservice.core.order.OrderRepository;
import com.jtl.microscape.orderservice.core.restaurant.MenuCategorie;
import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import com.jtl.microscape.orderservice.core.restaurant.RestaurantTestDataCreator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    public CommandLineRunner runner(OrderRepository orderRepository,
                                    CustomerTestDataCreator customerTestDataCreator,
                                    RestaurantTestDataCreator restaurantTestDataCreator) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) {
                Restaurant restaurant = restaurantTestDataCreator.create();

                entityManager.persist(restaurant);
                entityManager.persist(restaurant.getMenu());

                List<MenuCategorie> menuCategories = restaurant.getMenu().getMenuCategories();
                menuCategories.forEach(entityManager::persist);

                menuCategories.forEach(menuCategorie -> menuCategorie.getMenuItems().forEach(entityManager::persist));

                entityManager.persist(restaurant);

                Customer c = customerTestDataCreator.create();

                entityManager.persist(c);

                entityManager.detach(c);

                Order order = Order.builder()
                        .orderedBy(c)
                        .placedAt(Instant.now())
                        .restaurant(restaurant)
                        .build();

                order.addToOrderLineItems(OrderLineItem.builder()
                        .menuItem(menuCategories.get(0).getMenuItems().get(0))
                        .quantity(2)
                        .build());

                orderRepository.save(order);

            }
        };

    }

}
