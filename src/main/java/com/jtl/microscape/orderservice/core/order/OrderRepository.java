package com.jtl.microscape.orderservice.core.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("internalOrderRepository")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
