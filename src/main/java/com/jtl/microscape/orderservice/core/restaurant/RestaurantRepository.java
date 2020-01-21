package com.jtl.microscape.orderservice.core.restaurant;

import com.jtl.microscape.orderservice.util.repository.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends ReadOnlyRepository<Restaurant, Long> {
}
