package com.jtl.microscape.orderservice.core.restaurant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RestaurantWriteRepository extends CrudRepository<Restaurant, Long> {
}
