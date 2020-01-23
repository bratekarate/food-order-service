package com.jtl.microscape.orderservice.core.customer;

import org.springframework.data.repository.CrudRepository;

interface CustomerWriteRepository extends CrudRepository<Customer, Long> {
}
