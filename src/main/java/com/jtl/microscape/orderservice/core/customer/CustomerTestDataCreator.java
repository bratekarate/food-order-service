package com.jtl.microscape.orderservice.core.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class CustomerTestDataCreator {

    private final CustomerWriteRepository customerWriteRepository;

    public Customer create() {
        Customer hans = Customer.builder()
                .name("Hans")
                .build();

        return customerWriteRepository.save(hans);
    }
}
