package com.jtl.microscape.orderservice.core.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerTestDataCreator {

    private final CustomerWriteRepository customerWriteRepository;

    public Customer create() {
        Customer hans = Customer.builder()
                .name("Hans")
                .build();

        customerWriteRepository.save(hans);

        return hans;
    }
}
