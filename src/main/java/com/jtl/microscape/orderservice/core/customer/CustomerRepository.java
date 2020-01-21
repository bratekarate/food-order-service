package com.jtl.microscape.orderservice.core.customer;

import com.jtl.microscape.orderservice.util.repository.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReadOnlyRepository<Customer, Long> {
}
