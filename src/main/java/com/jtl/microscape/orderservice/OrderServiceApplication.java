package com.jtl.microscape.orderservice;

import com.jtl.microscape.orderservice.core.customer.Customer;
import com.jtl.microscape.orderservice.core.customer.CustomerRepository;
import com.jtl.microscape.orderservice.core.customer.CustomerTestDataCreator;
import com.jtl.microscape.orderservice.core.order.Order;
import com.jtl.microscape.orderservice.core.order.OrderLineItem;
import com.jtl.microscape.orderservice.core.order.OrderRepository;
import com.jtl.microscape.orderservice.core.restaurant.Restaurant;
import com.jtl.microscape.orderservice.core.restaurant.RestaurantRepository;
import com.jtl.microscape.orderservice.core.restaurant.RestaurantTestDataCreator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.Instant;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(OrderRepository orderRepository,
                                    CustomerTestDataCreator customerTestDataCreator,
                                    RestaurantTestDataCreator restaurantTestDataCreator,
                                    CustomerRepository customerRepository,
                                    RestaurantRepository restaurantRepository,
                                    PlatformTransactionManager transactionManager) {
        return args -> {

            var transactionTemplate = new TransactionTemplate(transactionManager);

            // create and persist shared restaurant entities using read-only repositories
            var savedRestaurant = transactionTemplate.execute(status -> {
                Restaurant newRestaurant = restaurantTestDataCreator.create();

                return newRestaurant;
            });

            // create and persist shared restaurant entities using read-only repositories
            var savedCustomer = transactionTemplate.execute(status -> {
                Customer newCustomer = customerTestDataCreator.create();

                return newCustomer;
            });

            // create and persist one order with an attached order line item
            var savedOrder = transactionTemplate.execute(status -> {
                Optional<Restaurant> fetchedRestaurant = restaurantRepository.findById(savedRestaurant.getId());

                Order newOrder = Order.builder()
                        .orderedBy(customerRepository.findById(savedCustomer.getId()).orElse(null))
                        .placedAt(Instant.now())
                        .restaurant(fetchedRestaurant.orElse(null))
                        .build();

                newOrder.addToOrderLineItems(OrderLineItem.builder()
                        .menuItem(fetchedRestaurant
                                .map(restaurant -> restaurant.getMenu().getMenuCategories().get(0).getMenuItems().get(0))
                                .orElse(null))
                        .quantity(2)
                        .build());

                return orderRepository.save(newOrder);
            });

            var orderId = savedOrder.getId();

            System.out.println(savedOrder);

            // add another order line item to order
            var savedOrder2 = transactionTemplate.execute(status -> {
                Optional<Restaurant> fetchedRestaurant = restaurantRepository.findById(savedRestaurant.getId());

                OrderLineItem newOrderLineItem = OrderLineItem.builder()
                        .quantity(1)
                        .menuItem(fetchedRestaurant
                                .map(existingRestaurant -> existingRestaurant.getMenu().getMenuCategories().get(0).getMenuItems().get(0))
                                .orElse(null))
                        .build();

                var fetchedOrder = orderRepository.findById(orderId).map(presentFetchedOrder -> {
                    // workaround for HHH-6776 (duplicates in collection after addition) by performing read operation on it after fetch
                    presentFetchedOrder.getOrderLineItems().size();
                    presentFetchedOrder.addToOrderLineItems(newOrderLineItem);
                    return orderRepository.save(presentFetchedOrder);
                });

                return fetchedOrder.orElse(null);
            });

            System.out.println(savedOrder2);

            // add another order line item to order
            var savedOrder3 = transactionTemplate.execute(status -> {
                Optional<Restaurant> fetchedRestaurant = restaurantRepository.findById(savedRestaurant.getId());

                OrderLineItem newOrderLineItem = OrderLineItem.builder()
                        .quantity(1)
                        .menuItem(fetchedRestaurant
                                .map(existingRestaurant -> existingRestaurant.getMenu().getMenuCategories().get(0).getMenuItems().get(0))
                                .orElse(null))
                        .build();

                var fetchedOrder = orderRepository.findById(orderId).map(presentFetchedOrder -> {
                    // workaround for HHH-6776 (duplicates in collection after addition) by performing read operation on it after fetch
                    presentFetchedOrder.getOrderLineItems().size();
                    presentFetchedOrder.addToOrderLineItems(newOrderLineItem);
                    return orderRepository.save(presentFetchedOrder);
                });

                return fetchedOrder.orElse(null);
            });

            System.out.println(savedOrder3);

        };

    }

}
