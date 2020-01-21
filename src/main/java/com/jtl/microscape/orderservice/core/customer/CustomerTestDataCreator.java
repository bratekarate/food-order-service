package com.jtl.microscape.orderservice.core.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerTestDataCreator {
    public Customer create() {
        return Customer.builder()
                .name("Hans")
                .build();
    }
}
